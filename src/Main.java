import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Main implements Serializable {
    private ArrayList<String > s ;
    public Main(){
        s = new ArrayList<>();
    }
    public Object deepClone() throws IOException{
        ByteArrayOutputStream copyString = new ByteArrayOutputStream();
        ObjectOutputStream backup = new ObjectOutputStream(copyString);
        backup.writeObject(this);

        ByteArrayInputStream copy = new ByteArrayInputStream(copyString.toByteArray());
        ObjectInputStream out = new ObjectInputStream(copy);
        return copy.read();
    }

    public ArrayList<String> getS() {
        try {
            this.deepClone();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}

class Main1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean []st = new boolean[n];
        int cnt = n;
        int start = 0;
        while (cnt>1){

            if (!st[(start+m)%cnt]){
                st[(start+m)%cnt] = true;
                cnt--;
            }else{
                while (st[(start+m)%cnt]) {
                    start++;
                }
            }

        }
        System.out.println(start);
    }
}