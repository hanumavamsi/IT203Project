import java.util.ArrayList;

public class Person {
 private final int number;
 private final int identity;
 public ArrayList<Person> voteFor;
 public ArrayList<Person> voteAgainst;
 public Person(int num,int iden) {
	 this.number = num;
	 this.identity = iden;
	 this.voteFor = new ArrayList<Person>();
	 this.voteAgainst = new ArrayList<Person>();
 }
 public int getNum(){
	 return this.number;
 }
 public int getIde() {
	 return this.identity;
 }
 public String toString() {
	 if (this.identity==1) {
		 return "Person " + this.getNum() + " is a Knight";
	 }else {
		 return  "Person " + this.getNum() + " is a Spy";
	 }
 }
 public int getFor_size() {
	 return this.voteFor.size();
 }
 public int getAgainst_size() {
	 return this.voteAgainst.size();
 }
 public void add_for(Person p) {
	 this.voteFor.add(p);
 }
 public void add_against(Person p) {
	 this.voteAgainst.add(p);
 }
}
