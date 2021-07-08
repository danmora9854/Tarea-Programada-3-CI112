public class ListaCategoria{
Categoria first;
Categoria last;
public ListaCategoria(){
  first=last=null;
}
  public void append(String  name){ //agrega al final
        if (first==null){
            first=last=new Categoria(name);
        }else{
            Categoria tmp=last;
            if (first==last){
                last=new Categoria(name);
                first.next=last;
                last.prev=tmp;
            }else{
                last.next=new Categoria(name);
                last=last.next;
                last.prev=tmp;
            }
        }
    }
 
  
}
