package com.yfy.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.yfy.db.KeyValueDb;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "KEY_VALUE_DB".
*/
public class KeyValueDbDao extends AbstractDao<KeyValueDb, Long> {

    public static final String TABLENAME = "KEY_VALUE_DB";

    /**
     * Properties of entity KeyValueDb.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Type = new Property(0, String.class, "type", false, "TYPE");
        public final static Property Model_type = new Property(1, String.class, "model_type", false, "MODEL_TYPE");
        public final static Property Parent_id = new Property(2, String.class, "parent_id", false, "PARENT_ID");
        public final static Property Child_id = new Property(3, String.class, "child_id", false, "CHILD_ID");
        public final static Property Required = new Property(4, boolean.class, "required", false, "REQUIRED");
        public final static Property View_type = new Property(5, int.class, "view_type", false, "VIEW_TYPE");
        public final static Property Key_value_id = new Property(6, String.class, "key_value_id", false, "KEY_VALUE_ID");
        public final static Property Key = new Property(7, String.class, "key", false, "KEY");
        public final static Property Value = new Property(8, String.class, "value", false, "VALUE");
        public final static Property Name = new Property(9, String.class, "name", false, "NAME");
        public final static Property Image = new Property(10, String.class, "image", false, "IMAGE");
        public final static Property Id = new Property(11, Long.class, "id", true, "_id");
    }


    public KeyValueDbDao(DaoConfig config) {
        super(config);
    }
    
    public KeyValueDbDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"KEY_VALUE_DB\" (" + //
                "\"TYPE\" TEXT NOT NULL ," + // 0: type
                "\"MODEL_TYPE\" TEXT NOT NULL ," + // 1: model_type
                "\"PARENT_ID\" TEXT NOT NULL ," + // 2: parent_id
                "\"CHILD_ID\" TEXT NOT NULL ," + // 3: child_id
                "\"REQUIRED\" INTEGER NOT NULL ," + // 4: required
                "\"VIEW_TYPE\" INTEGER NOT NULL ," + // 5: view_type
                "\"KEY_VALUE_ID\" TEXT NOT NULL ," + // 6: key_value_id
                "\"KEY\" TEXT NOT NULL ," + // 7: key
                "\"VALUE\" TEXT NOT NULL ," + // 8: value
                "\"NAME\" TEXT NOT NULL ," + // 9: name
                "\"IMAGE\" TEXT NOT NULL ," + // 10: image
                "\"_id\" INTEGER PRIMARY KEY );"); // 11: id
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"KEY_VALUE_DB\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, KeyValueDb entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getType());
        stmt.bindString(2, entity.getModel_type());
        stmt.bindString(3, entity.getParent_id());
        stmt.bindString(4, entity.getChild_id());
        stmt.bindLong(5, entity.getRequired() ? 1L: 0L);
        stmt.bindLong(6, entity.getView_type());
        stmt.bindString(7, entity.getKey_value_id());
        stmt.bindString(8, entity.getKey());
        stmt.bindString(9, entity.getValue());
        stmt.bindString(10, entity.getName());
        stmt.bindString(11, entity.getImage());
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(12, id);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, KeyValueDb entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getType());
        stmt.bindString(2, entity.getModel_type());
        stmt.bindString(3, entity.getParent_id());
        stmt.bindString(4, entity.getChild_id());
        stmt.bindLong(5, entity.getRequired() ? 1L: 0L);
        stmt.bindLong(6, entity.getView_type());
        stmt.bindString(7, entity.getKey_value_id());
        stmt.bindString(8, entity.getKey());
        stmt.bindString(9, entity.getValue());
        stmt.bindString(10, entity.getName());
        stmt.bindString(11, entity.getImage());
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(12, id);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 11) ? null : cursor.getLong(offset + 11);
    }    

    @Override
    public KeyValueDb readEntity(Cursor cursor, int offset) {
        KeyValueDb entity = new KeyValueDb( //
            cursor.getString(offset + 0), // type
            cursor.getString(offset + 1), // model_type
            cursor.getString(offset + 2), // parent_id
            cursor.getString(offset + 3), // child_id
            cursor.getShort(offset + 4) != 0, // required
            cursor.getInt(offset + 5), // view_type
            cursor.getString(offset + 6), // key_value_id
            cursor.getString(offset + 7), // key
            cursor.getString(offset + 8), // value
            cursor.getString(offset + 9), // name
            cursor.getString(offset + 10), // image
            cursor.isNull(offset + 11) ? null : cursor.getLong(offset + 11) // id
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, KeyValueDb entity, int offset) {
        entity.setType(cursor.getString(offset + 0));
        entity.setModel_type(cursor.getString(offset + 1));
        entity.setParent_id(cursor.getString(offset + 2));
        entity.setChild_id(cursor.getString(offset + 3));
        entity.setRequired(cursor.getShort(offset + 4) != 0);
        entity.setView_type(cursor.getInt(offset + 5));
        entity.setKey_value_id(cursor.getString(offset + 6));
        entity.setKey(cursor.getString(offset + 7));
        entity.setValue(cursor.getString(offset + 8));
        entity.setName(cursor.getString(offset + 9));
        entity.setImage(cursor.getString(offset + 10));
        entity.setId(cursor.isNull(offset + 11) ? null : cursor.getLong(offset + 11));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(KeyValueDb entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(KeyValueDb entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(KeyValueDb entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
