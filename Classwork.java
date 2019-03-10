import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class Classwork {

  public static List<String> makeAllWords(int k, int maxLetter) {
    List<String> data = new ArrayList<String>();
    makeAllWords(k, maxLetter, "", data);
    return data;
  }

  public static void makeAllWords(int k, int maxLetter, String str, List<String> data) {
    if (k == 0) {
      data.add(str);
    }
    else {
      for (int i = 0; i < maxLetter; i++) {
        makeAllWords(k-1,maxLetter,str+(char)(i+97),data);
      }
    }
  }

  public static int partition ( int [] data, int start, int end){
    Random rand = new Random();
    int s = start;
    int x = rand.nextInt(end+1-start) + start;
    System.out.println("array current status: " + Arrays.toString(data));
    int target = data[x];
    data[x] = data[start];
    data[start] = target;
    start+=1;
    System.out.println("array current status: " + Arrays.toString(data));
    System.out.println("target: " + target);
    while (start != end) {
      System.out.println("array current status: " + Arrays.toString(data));
      System.out.println("end: " + end);
      System.out.println("start: " + start);
      System.out.println("length of data: " + data.length);
      if (data[start] > target) {
        int temp = data[end];
        data[end] = data[start];
        data[start] = temp;
        end-=1;
      }
      else {
        start+=1;
      }
    }
    if (data[start] > target) {
      data[s] = data[start-1];
      data[start-1] = target;
    }
    else {
      data[s] = data[start];
      data[start] = target;
    }
    return start;
  }

  public static boolean test(int[] data, int k, int start, int end) {
      for (int i = start; i < end; i++) {
          if (i < k) {
              if (data[i] > data[k]) {
                  return false;
              }
          } else if (i > k) {
              if (data[i] < data[k]) {
                  return false;
              }
          }
      }
      return true;
  }

  public static void main(String[] args) {
    // int[] b = {1,2};
    // System.out.println(makeAllWords(3,3));
    // System.out.println(makeAllWords(4,2));
    // System.out.println(makeAllWords(1,26));
    // System.out.println(partition(b,2,9));

    int[] data1 = {10, 80, 30, 90, 40, 50, 70};
    //System.out.println(Arrays.toString(data1));
    int index1a = partition(data1, 0, 6);
    System.out.println("1a: " + test(data1, index1a,0,6));
    System.out.println(Arrays.toString(data1) + " "+index1a+"\n");
    System.out.println(Arrays.toString(data1));

    int index1b = partition(data1, 2, 5);
    System.out.println("1b: " + test(data1, index1b,2,5));
    System.out.println(Arrays.toString(data1) + " "+index1b+"\n");
  }
}
