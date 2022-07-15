import java.util.ArrayList;
import java.util.List;

public class forteAdvance4 {

    static ArrayList al = new ArrayList();

    static boolean logic(double ans, ArrayList<Double> arr, int i,double result) {

        if (i == arr.size()) {
            if (ans == result) {
                printArrayList(al);
                al.removeAll(al);
                return true;
            } else return false;
        }

        if (i == 0) {


            al.add(arr.get(0));
            if(!logic(arr.get(0), arr, i + 1, result)){
                al.remove(0);
            }
            else return true;

            al.add(arr.get(0) * 10 + arr.get(1));
            if(!logic(arr.get(0) * 10 + arr.get(1), arr, i + 2, result)){
                al.remove(0);
            }
            else return true;

            al.add((arr.get(0)*100+arr.get(1)*10+arr.get(2)));
            if(!logic(arr.get(0)*100+arr.get(1)*10+arr.get(2), arr, i + 3, result)){
                al.remove(arr.get(0)*100+arr.get(1)*10+arr.get(2));
            }else return true;

            al.add((arr.get(0)*1000+arr.get(1)*100+arr.get(2)*10+arr.get(3)));
            if(!logic((arr.get(0)*1000+arr.get(1)*100+arr.get(2)*10+arr.get(3)),arr,i+4,result)){
                al.remove(arr.get(0)*100+arr.get(1)*10+arr.get(2));
            }else return true;

        } else {
            al.add('+');
            al.add(arr.get(i));
            if (!logic(ans + arr.get(i), arr, i + 1, result)) {
                al.remove(al.size() - 1);
                al.remove(al.size() - 1);
            } else return true;

            al.add('-');
            al.add(arr.get(i));
            if (!logic(ans - arr.get(i), arr, i + 1, result)) {

                al.remove(al.size() - 1);
                al.remove(al.size() - 1);
            } else return true;



            al.add(0, '(');
            al.add(')');
            al.add('*');
            al.add(arr.get(i));
            if (!logic(ans * arr.get(i), arr, i + 1, result)) {
                al.remove(0);
                al.remove(al.size() - 1);
                al.remove(al.size() - 1);
                al.remove(al.size() - 1);

            } else return true;


            al.add(0, '(');
            al.add(')');
            al.add('/');
            al.add(arr.get(i));
            if (!logic(ans / arr.get(i), arr, i + 1, result)) {
                al.remove(0);
                al.remove(al.size() - 1);
                al.remove(al.size() - 1);
                al.remove(al.size() - 1);
            } else return true;

            if (i < 3) {

                al.add('+');
                double num1 = arr.get(i) * 10 + arr.get(i + 1);
                al.add(num1);
                if (!logic(ans + num1, arr, i + 2, result)) {
                    al.remove(al.size() - 1);
                    al.remove(al.size() - 1);
                } else return true;

                al.add('-');
                double num2 = arr.get(i) * 10 + arr.get(i + 1);
                al.add(num2);
                if (!logic(ans - num2, arr, i + 2, result)) {

                    al.remove(al.size() - 1);
                    al.remove(al.size() - 1);
                } else return true;

                al.add(0, '(');
                al.add(')');
                al.add('*');
                double num3 = arr.get(i) * 10 + arr.get(i + 1);
                al.add(num3);
                if (!logic(ans * num3, arr, i + 2, result)) {
                    al.remove(0);
                    al.remove(al.size() - 1);
                    al.remove(al.size() - 1);
                    al.remove(al.size() - 1);
                } else return true;

                al.add(0, '(');
                al.add(')');
                al.add('/');
                double num4 = arr.get(i) * 10 + arr.get(i + 1);
                al.add(num4);
                if (!logic(ans / num4, arr, i + 2, result)) {
                    al.remove(0);
                    al.remove(al.size() - 1);
                    al.remove(al.size() - 1);
                    al.remove(al.size() - 1);

                } else return true;

                if(i==1){
                    al.add('+');
                    al.add((arr.get(1)*100+arr.get(2)*10+arr.get(3)));
                    if(!logic(ans +arr.get(1)*100+arr.get(2)*10+arr.get(3), arr, i + 3, result)){
                        al.remove(al.size()-1);
                        al.remove(al.size()-1);
                    }else return true;

                    al.add('-');
                    al.add((arr.get(1)*100+arr.get(2)*10+arr.get(3)));
                    if(!logic(ans-(arr.get(1)*100+arr.get(2)*10+arr.get(3)), arr, i + 3, result)){
                        al.remove(al.size()-1);
                        al.remove(al.size()-1);
                    }else return true;

                    al.add('*');
                    al.add((arr.get(1)*100+arr.get(2)*10+arr.get(3)));
                    if(!logic(ans*(arr.get(1)*100+arr.get(2)*10+arr.get(3)), arr, i + 3, result)){
                        al.remove(al.size()-1);
                        al.remove(al.size()-1);
                    }else return true;

                    al.add('/');
                    al.add((arr.get(1)*100+arr.get(2)*10+arr.get(3)));
                    if(!logic(ans/(arr.get(1)*100+arr.get(2)*10+arr.get(3)), arr, i + 3, result)){
                        al.remove(al.size()-1);
                        al.remove(al.size()-1);
                    }else return true;
                }
            }


        }
        return false;
    }

    private static void printArrayList(ArrayList al) {

        for(int i =0;i<al.size();i++){
            if(al.get(i).equals("(")){
                System.out.print("(");
            }
            else if(al.get(i).equals(")")){
                System.out.print(")");
            }
            else if(al.get(i).equals("+")){
                System.out.print("+");
            }
            else if(al.get(i).equals("*")){
                System.out.print("*");
            }
            else if(al.get(i).equals("/")){
                System.out.print("/");
            }
            else if(al.get(i).equals("-")){
                System.out.print("-");
            }else{
                System.out.print(al.get(i));
            }

        }
        System.out.println();
    }

    private static void Permutation(int i, double[] nums, List<ArrayList<Double>> result) {
        if (i == nums.length - 1) {
            ArrayList<Double> list = new ArrayList<>();
            for (double n : nums) list.add(n);
            result.add(list);
        } else {
            for (int j = i, l = nums.length; j < l; j++) {
                swap(nums,i,j);
                Permutation(i + 1, nums, result);
                swap(nums,i,j);
            }
        }
    }

    public static void swap(double []nums,int i,int j){
        double temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
       
        double []arr = new double[4];
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num1:");
        arr[0] =  sc.nextDouble();


        System.out.println("Enter num2:");
        arr[1] =  sc.nextDouble();

        System.out.println("Enter num3:");
        arr[2] =  sc.nextDouble();

        System.out.println("Enter num4:");
        arr[3] =  sc.nextDouble();

        System.out.println("Enter required result");
        double result = sc.nextDouble();

        List<ArrayList<Double>> resultList = new ArrayList<>();
        Permutation(0,arr,resultList);
        
        for(ArrayList<Double> arrlist :resultList){

            if(!logic(0,  arrlist,0,13)){
                al.removeAll(al);
            }

        }

    }
}
