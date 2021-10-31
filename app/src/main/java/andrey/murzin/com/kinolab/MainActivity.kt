package andrey.murzin.com.kinolab

import andrey.murzin.core.Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import com.google.accompanist.insets.ProvideWindowInsets
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Theme {
                ProvideWindowInsets {
                    Scaffold(
                        bottomBar = {

                        }
                    ) {

                    }
                }
            }
        }
    }
}
