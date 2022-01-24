package ru.geekbrains.template_method;

public abstract class Builder {

        // Template method
        public final void build()
        {
            test();
            lint();
            assemble();
            deploy();
        }

        public abstract void test();
        public abstract void lint();
        public abstract void assemble();
        public abstract void deploy();
}
