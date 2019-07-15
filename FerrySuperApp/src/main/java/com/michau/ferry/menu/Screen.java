package com.michau.ferry.menu;

import java.sql.SQLException;

public interface Screen {
 void interact() throws SQLException;
 void interact(int input) throws SQLException;

}
