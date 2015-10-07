package cbpos1989.com.sqlitedatabase;

import android.provider.BaseColumns;

/**
 * Created by Colm O'Sullivan on 07/10/2015.
 */
public class DBFeederContract {

    public DBFeederContract() {
    }

    public static abstract class PersonTable implements BaseColumns {
        public static final String TABLE_NAME = "person";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PHONE_NUMBER = "phone_number";
        public static final String COLUMN_EMAIL = "email";
    }
}
