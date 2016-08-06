    class Alarm { 
      String alarm="on";  
    }  
     
    class Vehicle extends Alarm{  
      int speed=50;  
    }  
     
    class Bike4 extends Vehicle{  
      int speed=100;  
     
      void display(){  
       System.out.println(super.speed);//will print speed of Vehicle now  
       System.out.println(super.alarm);
      }  
      public static void main(String args[]){  
       Bike4 b=new Bike4();  
       b.display();  
     
    }  
    } 
/*
50
on 
*/