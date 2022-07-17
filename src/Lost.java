public class Lost {
     String lostTime;
     String lostPlace;
     String lostNums;

     public Lost(String lostTime,String lostPlace,String lostNums){
          this.lostTime=lostTime;
          this.lostPlace=lostPlace;
          this.lostNums=lostNums;
     }
}

class CardLost extends Lost{
     String cardNumber;
     String stuName;
     public CardLost(String lostTime, String lostPlace, String lostNums, String stuName,String cardNum) {
          super(lostTime, lostPlace, lostNums);
          this.cardNumber=cardNum;
          this.stuName=stuName;
     }
     void cardDetail(){
          System.out.print("lost time:"+lostTime+"lost num:"+lostNums+"card number:");
          System.out.println(cardNumber+"student:"+stuName+"lost place:"+lostPlace);
     }
}

class BookLost extends Lost{
     String bookName;
     public BookLost(String lostTime, String lostPlace, String lostNums, String name) {
          super(lostTime, lostPlace, lostNums);
          this.bookName=name;
     }
     void bookDetail(){
          System.out.print("lost time:"+lostTime+"lost num:"+lostNums);
          System.out.println("book name:"+bookName+"lost place:"+lostPlace);
     }
}