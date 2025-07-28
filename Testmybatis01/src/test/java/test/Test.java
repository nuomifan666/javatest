package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Book;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Object> list=sqlSession.selectList("a.b.selectAllBooks");
        for(int i=0;i<list.size();i++){
            Book book=(Book)list.get(i);
            System.out.println(book.getName()+"--"+book.getAuthor()+"--"+book.getPrice());
        }
        sqlSession.close();


    }
}
