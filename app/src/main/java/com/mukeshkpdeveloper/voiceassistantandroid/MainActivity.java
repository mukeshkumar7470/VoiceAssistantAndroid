package com.mukeshkpdeveloper.voiceassistantandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.alan.alansdk.AlanCallback;
import com.alan.alansdk.AlanConfig;
import com.alan.alansdk.button.AlanButton;
import com.alan.alansdk.events.EventCommand;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    /// Add AlanButton variable
    private AlanButton alanButton;
    private static final String ALAN_BUTTON = "AlanButton";
    /// Define the project key
    //other key: f5e57554206244ac1dc9a0d5cd74e85d2e956eca572e1d8b807a3e2338fdd0dc/stage
    //my key: 3c87cba1d78a39dd229a83170bd8edc12e956eca572e1d8b807a3e2338fdd0dc/stage
    AlanConfig config = AlanConfig.builder().setProjectId("f5e57554206244ac1dc9a0d5cd74e85d2e956eca572e1d8b807a3e2338fdd0dc/stage").build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alanButton = findViewById(R.id.alan_button);
        alanButton.initWithConfig(config);

        AlanCallback alanCallback = new AlanCallback() {
            /// Handle commands from Alan Studio
            @Override
            public void onCommand(final EventCommand eventCommand) {
                try {
                    JSONObject command = eventCommand.getData();
//                    Log.d("JSONObject", "Basic Object: " + command);
                    JSONObject data = command.getJSONObject("data");
//                    Log.d("JSONObject", "Data Object: " + data);
                    String commandName = data.getString("command");
                    executeCommand(commandName, data);
                } catch (JSONException e) {
                    Log.e(ALAN_BUTTON, e.getMessage());
                }
            }
        };
       /// Register callbacks
        alanButton.registerCallback(alanCallback);
    }

    private void executeCommand(String commandName, JSONObject data) {
        if (commandName.equals("go_back")) {
            onBackPressed();
        }

        if (commandName.equals("exit")) {
            alanButton.deactivate();
            Toast.makeText(this, "exit", Toast.LENGTH_SHORT).show();
            finish();
        }

        if (commandName.equals("log_out")) {
            Toast.makeText(this, "log_out", Toast.LENGTH_SHORT).show();
        }

        if (commandName.equals("open_todo")) {
            Toast.makeText(this, "open_todo", Toast.LENGTH_SHORT).show();
        }

        if (commandName.equals("add_task")) {
            Toast.makeText(this, "add_task", Toast.LENGTH_SHORT).show();
        }

        if (commandName.equals("set_title")) {
            try {
                String title = data.getString("title");
                Toast.makeText(this, " "+title, Toast.LENGTH_SHORT).show();

            } catch (JSONException e) {
                Log.e(ALAN_BUTTON, e.getMessage());
                alanButton.playText("I'm sorry I'm unable to do this at the moment");
            }
        }

        if (commandName.equals("set_description")) {
            try {
                String desc = data.getString("description");
                Toast.makeText(this, " "+desc, Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                Log.e(ALAN_BUTTON, e.getMessage());
                alanButton.playText("I'm sorry I'm unable to do this at the moment");
            }
        }

        if (commandName.equals("set_type")) {
            try {
                String type = data.getString("type");
                Toast.makeText(this, " "+type, Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                Log.e(ALAN_BUTTON, e.getMessage());
                alanButton.playText("I'm sorry I'm unable to do this at the moment");
            }
        }

        if (commandName.equals("refresh_tasks")) {
            Toast.makeText(this, "refresh_tasks", Toast.LENGTH_SHORT).show();
        }

        if (commandName.equals("confirm_add_task")) {
            Toast.makeText(this, "confirm_add_task", Toast.LENGTH_SHORT).show();
        }

        if (commandName.equals("read_tasks")) {
            Toast.makeText(this, "read_tasks", Toast.LENGTH_SHORT).show();
        }

        if (commandName.equals("highlight_task")) {
            try {
                int position = data.getInt("taskNo");
                Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                Log.e(ALAN_BUTTON, e.getMessage());
               alanButton.playText("I'm sorry I'm unable to do this at the moment");
            }
        }

        if (commandName.equals("check_task")) {
            try {
                int position = data.getInt("taskNo");
                Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                Log.e(ALAN_BUTTON, e.getMessage());
                alanButton.playText("I'm sorry I'm unable to do this at the moment");
            }
        }

        if (commandName.equals("open_timer")) {
            Toast.makeText(this, "open_timer", Toast.LENGTH_SHORT).show();
        }

        if (commandName.equals("start_timer")) {
            Toast.makeText(this, "start_timer", Toast.LENGTH_SHORT).show();
        }

        if (commandName.equals("pause_timer")) {
            Toast.makeText(this, "pause_timer", Toast.LENGTH_SHORT).show();
        }

        if (commandName.equals("reset_timer")) {
            Toast.makeText(this, "reset_timer", Toast.LENGTH_SHORT).show();
        }

        if (commandName.equals("short_break")) {
            Toast.makeText(this, "short_break", Toast.LENGTH_SHORT).show();
        }

        if (commandName.equals("long_break")) {
            Toast.makeText(this, "long_break", Toast.LENGTH_SHORT).show();
        }

        if (commandName.equals("stop_break")) {
            Toast.makeText(this, "stop_break", Toast.LENGTH_SHORT).show();
        }
    }
}