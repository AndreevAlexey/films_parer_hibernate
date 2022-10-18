package model;

import java.util.Objects;

public class BaseModel {
    protected long id;

    public BaseModel() {}

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        BaseModel bm = (BaseModel) obj;
        return this.id == bm.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
