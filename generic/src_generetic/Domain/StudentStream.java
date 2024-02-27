package Domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
// Класс для потока групп, показывающий поток и список групп.
public class StudentStream<V,M> implements Iterable<StudentGroup<V,M>>{
    private M numStream;
    private List<V> strgroup = new ArrayList<>();

    private List<StudentGroup<V,M>> grList; // Список групп одного потока

    public StudentStream(M numStream) {
        grList = new ArrayList<>();
        this.numStream = numStream;
    }

    public M getNumStream() {
        return numStream;
    }

    public List<StudentGroup<V,M>> getGrList() {
        return grList;
    }

    public void add(StudentGroup<V,M> group) {
        grList.add(group);
    }

    public List<V> strgroup() {
        strgroup = new ArrayList<>();
        for (int i = 0; i < grList.size(); i++) {
            for (int j = 0; j < grList.get(i).getGroup().size(); j++) {
                strgroup.add(grList.get(i).getGroup().get(j).getName());
            }

        }
        return  strgroup;
    }

    @Override
    public String toString() {

        return "Номер потока: " + numStream +
                ", количество групп: " + grList.size() +
                ", список групп: " + strgroup() +
                '.';
    }

    //Итератор групп студентов
    @Override
    public Iterator<StudentGroup<V,M>> iterator() {
        return new GroupIterator<V,M>(grList);
    }

}
