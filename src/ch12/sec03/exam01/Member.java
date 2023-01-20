package ch12.sec03.exam01;

import java.util.Objects;

public class Member {
    public String id;

    public Member(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Member target){
            if(id.equals(target.id)){
                return true;
            }
        }
        return false;
    }

}
