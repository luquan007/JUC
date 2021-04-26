public class LambdaExpres {
    Foo foo=new Foo() {
        @Override
        public void sayHello() {
            System.out.println("_______----_________");
        }
    };
}

interface Foo
{
    public void sayHello();
}