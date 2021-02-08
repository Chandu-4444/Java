import java.util.*;
class Bike  
{ 
    private int gear; 
    private int speed; 

    
          
    public Bike(int gear, int speed) 
    { 
        this.gear = gear; 
        this.speed = speed; 
    } 
          
    public void applyBrake(int decrement) 
    { 
        speed -= decrement; 
    } 
          
    public void speedUp(int increment) 
    { 
        speed += increment; 
    } 
    public int getGear() {
        return gear;
    }

    public int getSpeed() {
        return speed;
    }
      
    public String toString()  
    { 
        return("No of gears are "+getGear()
                +"\n"
                + "Speed of bike is "+getSpeed()); 
    }

    
} 
  
class MotorBike extends Bike  
{ 
      
    private int seatHeight; 
    private String type;

  
    public MotorBike(int gear,int speed, 
                        int startHeight, String type) 
    { 
        super(gear, speed); 
        seatHeight = startHeight; 
        this.type = type;
    }  
          
    public void setHeight(int newValue) 
    { 
        seatHeight = newValue; 
    }  

    public String getType()
    {
        return this.type;
    }

    public int getSeatHeight() {
        return seatHeight;
    }
    


    @Override
    public String toString() 
    { 
        return (super.toString()+ 
                "\nSeat height is "+getSeatHeight()+"\nType: "+getType()); 
    }

   


      
} 
  
public class Main  
{ 
    public static void main(String args[])  
    { 
          
        MotorBike mb = new MotorBike(3, 100, 25, "Racer"); 
        System.out.println(mb.toString()); 
              
    } 
} 