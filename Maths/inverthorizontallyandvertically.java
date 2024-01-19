import java.util.Arrays;

public class inverthorizontallyandvertically {
    public static int[][] flipandinvertimage(int[][] image) {
        for (int[] row : image) {
            for (int i = 0; i < image[0].length/2; i++) {
                    int temp = row[i]^1;
                    row[i] = row[image[0].length-1-i]^1;
                    row[image[0].length-1-i]= temp;
            }
        }
        return image;

    }

    public static void main(String[] args) {
        int[][] image ={
                {1,1,0},
                {1,0,1},
                {0,0,1}
        };
        for(int[] row : flipandinvertimage(image)){
            System.out.println(Arrays.toString(row));
        }
    }
}