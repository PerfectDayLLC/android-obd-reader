import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.pires.obd.reader.R;

public class hello extends Activity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toast.makeText(getBaseContext(), "Hello........", Toast.LENGTH_LONG).show();
    }
}