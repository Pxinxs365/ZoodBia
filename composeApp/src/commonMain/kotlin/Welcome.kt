import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import zoodbia.composeapp.generated.resources.Res
import zoodbia.composeapp.generated.resources.*

@Composable
@Preview
fun WelcomeScreen(
    navHostController: NavHostController
) {
    Box(
        modifier = Modifier.fillMaxSize()
            .paint(painterResource(Res.drawable.welcome_bg), contentScale = ContentScale.FillHeight)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(Res.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier.width(80.dp).height(60.dp)
                )
            }
            // TODO: combine into one Text component
            Text(
                text = "Welcome",
                fontSize = 48.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "to ZoodBia",
                fontSize = 48.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Get your groceries within the same day",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color.White.copy(alpha = 0.8f),
                modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)
            )

            Button(
                onClick = { navHostController.navigate("Login") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryTeal)
            ) {
                Text(
                    text = "Get Started",
                    fontSize = 18.sp,
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )

            }

            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen()
}