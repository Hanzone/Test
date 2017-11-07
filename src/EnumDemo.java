/**
 * Created by Haorenpu on 07/11/2017.
 */
public enum EnumDemo implements InterfaceDemo {
    A {
        @Override
        public void apply() {
            System.out.print(this.getClass());
        }
    }


}
