package com;

class LambdaTest {
    public static void main(String[] args) {
        new Thread(
                () -> System.out.println("lambda test-----")
        );

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("lambda test-----");
                    }
                }
        );
    }
}
