import java.util.*;

class Solution {

    class Song {
        int index;
        int play;

        Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
    }

    class GenreInfo {
        String name;
        int totalPlay;

        GenreInfo(String name, int totalPlay) {
            this.name = name;
            this.totalPlay = totalPlay;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        Map<String, List<Song>> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.computeIfAbsent(genres[i], k -> new ArrayList<>())
               .add(new Song(i, plays[i]));
        }

        List<GenreInfo> genreInfo = new ArrayList<>();
        for (String name : map.keySet()) {
            int sum = 0;
            for (Song s : map.get(name)) {
                sum += s.play;
            }
            genreInfo.add(new GenreInfo(name, sum));
        }

        genreInfo.sort((a, b) -> b.totalPlay - a.totalPlay);

        List<Integer> result = new ArrayList<>();

        for (GenreInfo gi : genreInfo) {
            List<Song> songList = map.get(gi.name);

            songList.sort((a, b) -> {
                if (a.play != b.play) return b.play - a.play;
                return a.index - b.index;
            });

            for (int i = 0; i < songList.size() && i < 2; i++) {
                result.add(songList.get(i).index);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
