import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Messagenode{
    String message;
    LocalDateTime time;
    Messagenode next;
    Messagenode(String message,LocalDateTime time){
        this.message=message;
        this.time=time;
        this.next=null;
    }
}
class person{
    String id;
    Messagenode head;
    Messagenode tail;

    public person(String id) {
        this.id=id;
        this.head=null;
        this.tail=null;

    }


    

}
 class MessageAdd{
    Map<String,person> map;
    String id;
    public MessageAdd() {
        map=new HashMap<>();
      

    }
    
    void messageadd(String message,String id){
    person p=map.computeIfAbsent(id, k->new person(k));
    Messagenode node=new Messagenode(message, LocalDateTime.now());
    if(p.head==null){
        p.head=node;
        p.tail=node;

    }
    else{
        p.tail.next=node;
        p.tail=node;

    }
    notifys(message);
    }
    void notifys(String message){
        System.out.println("Message Added"+" "+message);
    }
     List<String> getMessages(String id){
        person person=map.get(id);
        Messagenode message=person.head;
        ArrayList<String>messg=new ArrayList<>();
        if(message==null){
            return null;
        }
        Messagenode current=message;
        while(current!=null){
            messg.add("Message:"+" " +current.message +" time:"+" "+current.time);
            current=current.next;
        }
        return messg;

        
     
        

    }
    


}
class Notify{
public static void main(String[] args){
    MessageAdd n=new MessageAdd();
    n.messageadd("hey world", "1");
    n.messageadd("hey buddy", "2");
    n.messageadd("message", "3");
    n.messageadd("hey world 2", "1");
    n.messageadd("hey buddy", "2");
    n.messageadd("message", "3");
    List<String> result= n.getMessages("2");
    for(String i:result){
        System.out.println(i);
    }
}
}