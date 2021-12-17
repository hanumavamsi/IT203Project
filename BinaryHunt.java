import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class BinaryHunt {
	public static boolean search(int[] arr,int key) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==key)
				return true;
		}
		return false;
	}
	public static int[] randomArray(int spy_num,int size) {
		int[] arr=new int[spy_num];
		
		for(int i=0;i<spy_num;i++) {
			 int rand = (int)(Math.random()*(size-1));
		if(search(arr,rand)) {
			i--;
		}
		else
			arr[i]=rand;
		}
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 Scanner sc = new Scanner(System.in);
 
 System.out.print("Enter the number of people in the room :");
 int size = sc.nextInt();
 int spy_num;
 do {
 System.out.print("Enter the number of spies in the room :");
 spy_num = sc.nextInt();
 if(spy_num>size/2 ) {
	 System.out.print("Since the spies are in majority their identity cannot be predicted \n\n");
 }
	}while(spy_num>size/2);
//ArrayList<Person> room = new ArrayList<Person>();
Person[] arr = new Person[size];
int[] spy_pos=randomArray(spy_num,size);

for(int i=0;i<spy_pos.length;i++) {
	arr[spy_pos[i]] = new Person(spy_pos[i],0);
}
for(int j=0;j<size;j++) {
	if(arr[j]== null) {
		arr[j] = new Person(j,1);
	}
}
Person[] confidential=arr;
int rejected=0;
int ques_knight=0;
while(arr.length!=1) {
	ArrayList<Person> per=new ArrayList<Person>();
	if(arr.length%2==0) {
		
		for(int i=0;i<arr.length-1;i=i+2) {
			if(((arr[i].getIde()==1)&&(arr[i+1].getIde()==1))||((arr[i].getIde()==0)&&(arr[i+1].getIde()==0))) {
				per.add(arr[i]);
				ques_knight+=2;
		}
			else 
				rejected+=2;
		}
			arr=new Person[per.size()];
		for(int j=0;j<per.size();j++) {
			arr[j]=per.get(j);
		}
	
}
	else {
		for(int i=0;i<arr.length-1;i=i+2) {
			if(((arr[i].getIde()==1)&&(arr[i+1].getIde()==1))||((arr[i].getIde()==0)&&(arr[i+1].getIde()==0))) {
				per.add(arr[i]);
				ques_knight+=2;
		}
			else
				rejected+=2;
		}
	per.add(arr[arr.length-1]);
	arr=new Person[per.size()];
	for(int j=0;j<per.size();j++) {
		arr[j]=per.get(j);
	}
	}
}
int total_questions=(ques_knight+rejected)+rejected/2;
System.out.println("\n"+arr[0]+"\n");
System.out.println("**********************************************");
System.out.println("The total questions asked in this method is "+total_questions);
System.out.println("\n**********************************************\n");
System.out.println("Questions required to get the first knight  "+(ques_knight+rejected));
System.out.println("\n**********************************************\n");
System.out.println("After we get a knight, we ask question to that knight\nEventually we get the true identity of everyone as: \n");
for(int i = 0;i<size;i++) {
System.out.println(confidential[i].toString());
}
}
}