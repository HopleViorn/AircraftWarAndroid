package edu.hitsz.bus;
import java.util.ArrayList;
import java.util.List;

public class Publisher {
    List<Subscriber> subscriberList;
    public Publisher() {
        subscriberList=new ArrayList<>();
    }
    public void subscribe(Subscriber subscriber){
        subscriberList.add(subscriber);
    }
    public List<Subscriber> getSubscribeList(){
        return subscriberList;
    }
    public void unsubscribe(Subscriber subscriber){
        subscriberList.remove(subscriber);
    }

    public void publish(MeEvent meEvent){
        if(subscriberList.isEmpty()) return ;
        for(Subscriber subscriber:subscriberList){
            subscriber.listen(meEvent);
        }
    }
}
