
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MyUtil implements SqlUtil {
    /**
     * 根据传入的参数返回查询语句
     * @param user
     * @return 返回查询语句
     */
    @Override
    public String query(User user) {
        String SQL = "SELECT * FROM ";
        Class clazz = user.getClass();

        //获取表名
        Table table = (Table) clazz.getAnnotation(Table.class);
        String tableName = table.value();
        SQL += "'" + tableName + "' WHERE ";

        //获取属性
        Field fields[] = clazz.getDeclaredFields();
        int andTemp = 0;//andTemp用于添加AND
        try {
            for (int i = 0 ; i < fields.length ; i++){

                fields[i].setAccessible(true);
                Object value = fields[i].get(user);
                if (value != null && !value.equals(0)){
                    if (andTemp != 0){
                        SQL += " AND ";
                    }
                    //通过注解获取列名
                    Column column = (Column) fields[i].getAnnotation(Column.class);
                    String columnName = column.value();
                    //获取数据类型
                    String type = fields[i].getType().toString();
                    switch (type){
                        case "int":
                            SQL += columnName + "=" + value;
                            andTemp++;
                            break;
                        case "class java.lang.String":
                            SQL += columnName + " LIKE '" + value + "'";
                            andTemp++;
                            break;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        SQL += ";";

        return SQL;
    }

    /**
     * 根据传入的参数返回插入语句
     * @param user
     * @return 返回插入语句
     */
    @Override
    public String insert(User user) {
        String SQL = "INSERT INTO ";
        Class clazz = user.getClass();

        //获取表名
        Table table = (Table) clazz.getAnnotation(Table.class);
        String tableName = table.value();
        SQL += "'" + tableName + "' ";

        //获取属性
        Field fields[] = clazz.getDeclaredFields();
        List<String> columnNames = new ArrayList<>();
        List<String> columnValues = new ArrayList<>();
        try {
            for (int i = 0 ; i < fields.length ; i++){
                fields[i].setAccessible(true);
                Object value = fields[i].get(user);
                if (value != null && !value.equals(0)){
                    //通过注解获取列名
                    Column column = (Column) fields[i].getAnnotation(Column.class);
                    columnNames.add(column.value());
                    columnValues.add(value.toString());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        SQL += "(";
        int temp = 0;//temp用来添加逗号
        for (String columnName: columnNames){
            if (temp != 0){
                SQL += ", ";
            }
            SQL += "'"+columnName+"'";
            temp++;
        }
        SQL += ") VALUES ";

        SQL += "(";
        temp = 0;//同样作用
        for (String columnValue: columnValues){
            if (temp != 0){
                SQL += ", ";
            }
            SQL += "'"+columnValue+"'";
            temp++;
        }
        SQL += ");";
        return SQL;
    }

    /**
     * 根据传入的参数返回插入语句
     * @param users
     * @return 返回插入语句
     */
    @Override
    public String insert(List<User> users) {
        User u = users.get(0);
        String SQL = "INSERT INTO ";
        Class clazz = u.getClass();

        //获取表名
        Table table = (Table) clazz.getAnnotation(Table.class);
        String tableName = table.value();
        SQL += "'" + tableName + "' ";

        //获取属性
        Field fields[] = clazz.getDeclaredFields();
        List<String> columnNames = new ArrayList<>();
        try {
            for (int i = 0 ; i < fields.length ; i++){
                fields[i].setAccessible(true);
                Object value = fields[i].get(u);
                if (value != null && !value.equals(0)){
                    //通过注解获取列名
                    Column column = (Column) fields[i].getAnnotation(Column.class);
                    columnNames.add(column.value());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        SQL += "(";
        int temp = 0;//i用来添加逗号
        for (String columnName: columnNames){
            if (temp != 0){
                SQL += ", ";
            }
            SQL += "'"+columnName+"'";
            temp++;
        }
        SQL += ") VALUES ";

        int valueTemp = 0;//用来添加逗号
        for (User user: users){
            if (valueTemp != 0){
                SQL += ",";
            }

            List<String> columnValues = new ArrayList<>();
            try {
                for (int i = 0 ; i < fields.length ; i++){
                    fields[i].setAccessible(true);
                    Object value = fields[i].get(user);
                    if (value != null && !value.equals(0)){
                        columnValues.add(value.toString());
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            SQL += "(";
            temp = 0;//同样作用
            for (String columnValue: columnValues){
                if (temp != 0){
                    SQL += ", ";
                }
                SQL += "'"+columnValue+"'";
                temp++;
            }
            SQL += ")";
            valueTemp++;
        }

        SQL += ";";
        return SQL;
    }

    /**
     * 根据传入的参数返回删除语句（删除id为user.id的记录）
     * @param user
     * @return 返回删除语句
     */
    @Override
    public String delete(User user) {
        String SQL = "DELETE FROM ";
        Class clazz = user.getClass();

        //获取表名
        Table table = (Table) clazz.getAnnotation(Table.class);
        String tableName = table.value();
        SQL += "'" + tableName + "' WHERE ";

        //获取属性
        Field fields[] = clazz.getDeclaredFields();
        try {
            for (int i = 0 ; i < fields.length ; i++){

                fields[i].setAccessible(true);
                Object value = fields[i].get(user);
                //通过注解获取列名
                Column column = (Column) fields[i].getAnnotation(Column.class);
                String columnName = column.value();
                if (columnName.equals("id")){
                    SQL += "id=" + value;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        SQL += ";";

        return SQL;
    }

    /**
     * 根据传入的参数返回更新语句（将id为user.id的记录的其它字段更新成user中的对应值）
     * @param user
     * @return 返回更新语句
     */
    @Override
    public String update(User user) {
        String SQL = "UPDATE ";
        Class clazz = user.getClass();

        //获取表名
        Table table = (Table) clazz.getAnnotation(Table.class);
        String tableName = table.value();
        SQL += "'" + tableName + "' SET ";

        //获取属性
        Field fields[] = clazz.getDeclaredFields();

        int id = 0; //获取用户id
        int temp = 0;//temp用于添加逗号
        try {
            for (int i = 0 ; i < fields.length ; i++){

                fields[i].setAccessible(true);
                Object value = fields[i].get(user);
                if (value != null && !value.equals(0)){
                    if (temp != 0){
                        SQL += ", ";
                    }
                    //通过注解获取列名
                    Column column = (Column) fields[i].getAnnotation(Column.class);
                    String columnName = column.value();
                    if (columnName.equals("id")){
                        id = (int)value;
                        continue;
                    }
                    //获取数据类型
                    String type = fields[i].getType().toString();
                    switch (type){
                        case "int":
                            SQL += columnName + "=" + value;
                            temp++;
                            break;
                        case "class java.lang.String":
                            SQL += columnName + " = '" + value + "'";
                            temp++;
                            break;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        SQL += " WHERE id=" + id;
        SQL += ";";
        return SQL;
    }
}
