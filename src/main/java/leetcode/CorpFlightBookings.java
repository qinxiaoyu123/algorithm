package leetcode;

public class CorpFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = 0;
        }
        if (bookings.length == 0) return answer;
        for (int i = 0; i < bookings.length; i++) {
            for (int k = bookings[i][0]; k <= bookings[i][1]; k++) {
                answer[k-1] += bookings[i][2];
            }
        }
        return answer;
    }
}
