public class ListaPais{
Pais first;
Pais last;
public ListaPais(){
  first=last=null;
}
  public void append(String  name){ //agrega al final
        if (first==null){
            first=last=new Pais(name);
        }else{
            Pais tmp=last;
            if (first==last){
                last=new Pais(name);
                first.next=last;
                last.prev=tmp;
            }else{
                last.next=new Pais(name);
                last=last.next;
                last.prev=tmp;
            }
        }
    }
 
  
}
