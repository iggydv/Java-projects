package Task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void pushTest() {
        System.out.println("Test push\n================");
        Solution sol = new Solution();
        sol.push(1);
        assertEquals(1, sol.top());
        assertEquals(1, sol.count());
        System.out.println("================");
    }

    @Test
    public void topTest() {
        System.out.println("Test top\n================");
        Solution sol = new Solution();
        sol.push(1);
        sol.push(2);
        sol.push(3);
        assertEquals(3, sol.top());
        System.out.println("================");
    }

    @Test
    public void popTest() {
        System.out.println("Test pop\n================");
        Solution sol = new Solution();
        sol.push(1);
        sol.push(2);
        sol.push(3);
        sol.pop();
        assertEquals(2, sol.top());
        System.out.println("================");
    }

    @Test
    public void rollbackTest() {
        System.out.println("Test rollback\n================");
        Solution sol = new Solution();
        sol.begin();
        sol.push(10);
        sol.push(11);
        sol.push(12);
        sol.push(13);
        boolean returned = sol.rollback();
        assertTrue(returned);
        assertEquals(0, sol.count());
        System.out.println("================");
    }

    @Test
    public void commitTest() {
        System.out.println("Test commit\n================");
        Solution sol = new Solution();
        sol.begin();
        sol.push(10);
        sol.push(11);
        sol.push(12);
        sol.push(13);
        boolean returned = sol.commit();
        assertTrue(returned);
        assertEquals(4, sol.count());
        System.out.println("================");
    }

    @Test
    public void transactionsTest() {
        System.out.println("Test transactions\n================");
        Solution sol = new Solution();
        sol.push(1);

        Thread a = new Thread(() -> {
            sol.begin();
            sol.push(22);
            sol.push(33);
            sol.push(44);
            sol.push(55);
            boolean t1Commit = sol.commit();
        });

        Thread b = new Thread(() -> {
            sol.begin();
            sol.push(666);
            sol.push(777);
            sol.push(888);
            sol.push(999);
            boolean t2Commit = sol.commit();
        });

        Thread c = new Thread(() -> {
            sol.begin();
            sol.push(10);
            sol.push(11);
            sol.push(12);
            sol.push(13);
            boolean t3Rollback = sol.rollback();
            sol.push(14);
            sol.push(15);
            sol.push(16);
            sol.push(17);
            boolean t3Commit = sol.commit();
        });

        a.start();
        b.start();
        c.start();

        try {
            a.join();
            b.join();
            c.join();
        } catch (InterruptedException e) {
            System.out.print("Thread interrupted" + e);
        }

        assertEquals(13, sol.count());
        System.out.println("================");
    }
}