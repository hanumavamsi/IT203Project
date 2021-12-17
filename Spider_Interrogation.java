
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Spider_Interrogation {
	public static boolean search(int[] arr,int key) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==key)
				return true;
		}
		return false;
	}
	public static Person vote_gen(Person a , Person b ) {
	if(a.getIde()==1) {
		if(b.getIde()==1) {
			a.add_for(b);
		}
		else {
			int rand = (int)(Math.random()*2);
			if(rand == 0) {
				a.add_against(b);
			}else {
				a.add_for(b);
			}
		}
	}
	if(a.getIde()==0) {
		if(b.getIde()==1) {
			a.add_against(b);
		}else {
			int rand = (int)(Math.random()*2);
			if(rand == 0) {
				a.add_against(b);
			}else {
				a.add_for(b);
			}
		}
	}
	return a;
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
	 System.out.print("Since the spies are in majority their identity cannot be predicted \n");
 }
 
 int temp_spysize = spy_num;
	}while(spy_num>size/2);
//ArrayList<Person> room = new ArrayList<Person>();
Person[] arr = new Person[size];
int[] spy_pos=randomArray(spy_num,size);
Person Supreme_knight=null;
for(int i=0;i<spy_pos.length;i++) {
	arr[spy_pos[i]] = new Person(spy_pos[i],0);
}

for(int j=0;j<size;j++) {
	if(arr[j]== null) {
		arr[j] = new Person(j,1);
	}
}
int untouched=0;
 ArrayList<Person> rejPer = new ArrayList<Person>();
  for(int i=0;i<size; i += arr[i].getFor_size() +arr[i].getAgainst_size()) {
	  for(int j=i+1;j<size ;j++) {  

		arr[i]=vote_gen(arr[i],arr[j]);
		untouched=size-j;
		  if(arr[i].getAgainst_size()>arr[i].getFor_size()) {
			rejPer.add(arr[i]);
			untouched=size-j;
			break;
		  }
		  
	  }
	  if(arr[i].getFor_size()>=spy_num) {
		  Supreme_knight=arr[i];
		  break;
	  }
	  
	  spy_num-=arr[i].getAgainst_size();
	  
  }
  System.out.println(Supreme_knight);
  //For total questions
  int totalques=0;
  totalques+=rejPer.size();//Rejected In Step I
for(int i=0;i<rejPer.size();i++) {
	if(rejPer.get(i).getIde()==1) {
		totalques+=rejPer.get(i).getFor_size();//Supporter of knight
	}
	else
		totalques+=rejPer.get(i).getAgainst_size();//Rejectors of spy
}
//Now supporters of supreme knight

totalques+=Supreme_knight.getFor_size();
totalques-=(size/5);
totalques+=Supreme_knight.getAgainst_size()+Supreme_knight.getFor_size();
totalques-=untouched;

for(int i =0;i<size;i++) {
	System.out.println(arr[i].toString());
}
System.out.println("The total number of questions used are :"+totalques);

	}
	
}

