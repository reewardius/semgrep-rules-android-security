public class InnerClassReferenceLeakActivity extends AppCompatActivity {
  private static LeakyClass leakyClass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        new LeakyClass(this).redirectToSecondScreen();

         leakyClass = new LeakyClass(this);
         leakyClass.redirectToSecondScreen();
    }
    
    private class LeakyClass {
        
        private Activity activity;
        public LeakyClass(Activity activity) {
            this.activity = activity;
        }
        
        public void redirectToSecondScreen() {
            this.activity.startActivity(new Intent(activity, SecondActivity.class));
        }
    }
}

public class T{
    public class C{
        private void set(Activity a){
            int b = 3;
        }
    }
}