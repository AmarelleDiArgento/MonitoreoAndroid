package com.lotus.monitoreoandroid.Configuracion.DAO;

import java.sql.ResultSet;
import java.util.List;

public interface DAO<K,O,S>{

    String insert(O o) throws Exception;
    String update(O o) throws Exception;
    String delete(K id) throws Exception;
    O gift(ResultSet rs) throws Exception;
    O oneId(K id)throws Exception;
    boolean local()throws Exception;
    List<O> all() throws Exception;
}
