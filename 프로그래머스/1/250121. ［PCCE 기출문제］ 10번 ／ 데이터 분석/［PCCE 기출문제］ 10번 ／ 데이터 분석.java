import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static class Data{
      int code;
      int date;
      int maximum;
      int remain;

        public Data(int[] data) {
            this.code = data[0];
            this.date = data[1];
            this.maximum = data[2];
            this.remain = data[3];
        }

        // 데이터를 배열로 변환하는 메서드
        public int[] toArray() {
            return new int[]{code, date, maximum, remain};
        }
    }

    /**
     * 주어진 데이터 중 ext에 지정된 값이 val_ext 보다 적은 값들만 뽑은 후,
     * sort_by 에 해당하는 값을 기준으로 오름차순으로 정렬핢
     * @param data 정렬 할 데이터
     * @param ext 필터링할 데이터
     * @param val_ext 필터링 될 기준
     * @param sort_by 정렬 기준(오름차순)
     * @return 정렬된 값
     */

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 객체 리스트로 변환
        List<Data> dataList = Arrays.stream(data)
                .map(Data::new)
                .collect(Collectors.toList());
        // 필터링 && 정렬 후 int [][] 로 변환
        List<int[]> filterdSortedList = dataList.stream()
                .filter(d -> getFieldValue(d, ext) < val_ext)
                .sorted(Comparator.comparingInt(d -> getFieldValue(d, sort_by)))
                .map(Data::toArray)
                .collect(Collectors.toList());
        return filterdSortedList.toArray(new int[0][]);
    }

    /**
     * 주어진 필드명을 기준으로 Data 객체의 필드 값을 가져오는 메서드
     */
    private int getFieldValue(Data d, String field) {
        return switch (field) {
            case "code" -> d.code;
            case "date" -> d.date;
            case "maximum" -> d.maximum;
            case "remain" -> d.remain;
            default -> throw new IllegalArgumentException("잘못된 필드명: " + field);
        };
    }
}