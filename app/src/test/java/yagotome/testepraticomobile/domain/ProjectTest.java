package yagotome.testepraticomobile.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 */
public class ProjectTest {
    @Test
    public void testGetCommentsAmountWithoutComments() {
        Project project = new Project();
        assertEquals("0", project.getCommentsAmount());
        project.setComments(new ArrayList<Comment>());
        assertEquals("0", project.getCommentsAmount());
    }
    @Test
    public void testGetCommentsAmountWithComments() {
        Project project = new Project();
        List<List<Comment>> commentsList = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            int n = (int)Math.pow(10d, i);
            commentsList.add(new ArrayList<Comment>(n));
            for (int j = 0; j < n; j++) {
                commentsList.get(i).add(new Comment());
            }
        }
        //1 dígito
        project.setComments(commentsList.get(0));
        assertEquals("1", project.getCommentsAmount());
        //2 dígitos
        project.setComments(commentsList.get(1));
        assertEquals("10", project.getCommentsAmount());
        //3 dígitos
        project.setComments(commentsList.get(2));
        assertEquals("100", project.getCommentsAmount());
        //4 dígitos
        project.setComments(commentsList.get(3));
        assertEquals("1k", project.getCommentsAmount());
        //5 dígitos
        project.setComments(commentsList.get(4));
        assertEquals("10k", project.getCommentsAmount());
        //6 dígitos
        project.setComments(commentsList.get(5));
        assertEquals("100k", project.getCommentsAmount());
        //7 dígitos
        project.setComments(commentsList.get(6));
        assertEquals("1M", project.getCommentsAmount());
        //8 dígitos
        project.setComments(commentsList.get(7));
        assertEquals("10M", project.getCommentsAmount());
        /*
        //9 dígitos
        project.setComments(commentsList.get(8));
        assertEquals("100M", project.getCommentsAmount());
        //10 dígitos
        project.setComments(commentsList.get(9));
        assertEquals("1G", project.getCommentsAmount());
        //11 dígitos
        project.setComments(commentsList.get(10));
        assertEquals("10G", project.getCommentsAmount());
        //12 dígitos
        project.setComments(commentsList.get(11));
        assertEquals("100G", project.getCommentsAmount());
        */
    }
}