package project.stack;

import java.util.Scanner;

class Stack
{
    double []a;
    int top,size,len;
    public Stack(int n)
    {
        size=n;
        len=0;
        a=new double[size];
        top=-1;
    }
    public boolean isEmpty()
    {
        if(len==0)
            return true;
        else
            return false;
    }
    public boolean isFull()
    {
        if(len==size)
            return true;
        else
            return false;
    }
    public int getSize()
    {
        return len;
    }
    public double peek()
    {
        if(isEmpty())
            return 8000;
        else
            return a[top];
    }
    public void push(double i)
    {
        if(top+1>=size)
        {
            System.out.println("Satck is Full, Cannot push this value");
        }
        else
        {
            a[++top]=i; 
            len++;  
        }
    }
    public double pop()
    {
        if(isEmpty())
            return 8000;
        else
        {
        len--;
        return a[top--];
        }
    }
    public void sortAscending(Stack s,Stack tmpstack,Stack tmp)
    {
        if(len==0)
            System.out.println("There is no Element in the Stack to Sort them");
        else
            {
                while(!s.isEmpty())
                {
                    tmp.push(s.pop());
                    while(!tmpstack.isEmpty() && tmpstack.peek()<tmp.peek())
                    {
                        s.push(tmpstack.pop());
                    }
                    tmpstack.push(tmp.pop());
                }
                while(!tmpstack.isEmpty())
                {
                    tmp.push(tmpstack.pop());
                    while(!s.isEmpty() && s.peek()<tmp.peek())
                    {
                        tmpstack.push(s.pop());
                    }
                    s.push(tmp.pop());
                }
            }
    }
    public void display()
    {
        if(isEmpty())
            System.out.println("[ ]");
        else
            {
                for(int i=top;i>=0;i--)
                    System.out.print(a[i]+" ");
            }
    }
}


public class ProjectStack {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n;
        System.out.print("Enter Size of Stack : ");
        n=in.nextInt();
        while(n==0 || n<0)
        {
            System.out.println("Please, Enter size greater than zero.");
            System.out.print("Enter Size of Stack : ");
            n=in.nextInt();
        }
        Stack s=new Stack(n);
        Stack tmpstack=new Stack(n);
        Stack tmp=new Stack(n);
        char ans='y',lop,lop1;
        int choice;
        double i,t;
        while(ans=='Y' || ans=='y')
        {
            System.out.print("Choose You Option");
            System.out.println();
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. GetSize");
            System.out.println("5 .isEmpty");
            System.out.println("6 .SortAscending");
            System.out.println();
            System.out.print("Enter Your Choice : ");
            choice=in.nextInt();
            System.out.println("*******************");
            if(choice==1)
            {
                lop='y';
                while(lop=='y' || lop=='Y')
                {
                System.out.print("Enter the value which you want to push it : ");
                i=in.nextDouble();
                s.push(i);
                if(!s.isFull())
                {
                    System.out.println("Value is added to Stack");
                }
                System.out.print("Do you want to push any value again, (Type y or n) : ");
                lop=in.next().charAt(0);
                if(lop!='y' && lop!='Y')
                    break;
                }
                System.out.println("*******************");
                System.out.print("Your Stack is : ");
                s.display();
            }
            else if(choice==2)
            {
                lop1='y';
                while(lop1=='y' || lop1=='Y')
                {
                    t=s.pop();
                    if(t==8000)
                    {    
                        System.out.println("Stack is Empty, Cannot remove value");
                        break;
                    }
                    else
                    {   
                        System.out.println(t+" is removed from Stack");
                        System.out.print("Do you want to pop again, (Type y or n) : ");
                        lop1=in.next().charAt(0);
                        if(lop1!='y' && lop1!='Y')
                            break;
                    }
                }
                System.out.println("*******************");
                System.out.print("Your Stack is : ");
                s.display();
            }
            else if(choice==3)
            {
                t=s.peek();
                if(t==8000)
                    System.out.println("Stack is Empty, Cannot peek value");
                else
                    System.out.println("Peeked Value is "+t);
                System.out.println("*******************");
                System.out.print("Your Stack is : ");
                s.display();
            }
            else if(choice==4)
            {
                System.out.println("Size of Stack is "+s.getSize());
                System.out.println("*******************");
                System.out.print("Your Stack is : ");
                s.display();
            }
            else if(choice==5)
            {
                System.out.println(s.isEmpty());
                System.out.println("*******************");
                System.out.print("Your Stack is : ");
                s.display();
            }
            else if(choice==6)
            {
                s.sortAscending(s,tmpstack,tmp);
                System.out.print("Your Stack is : ");
                s.display();
            }
            else
            {
                System.out.println("Wrong Choice");
                System.out.println("*******************");
                System.out.print("Your Stack is : ");
                s.display();
            }
            System.out.println();
            System.out.println("*******************");
            System.out.print("Do you want to try anther choice ?! (Type y or n) : ");
            ans=in.next().charAt(0);
            if(ans!='Y' && ans!='y')
                break;
        }
    }
    
}
