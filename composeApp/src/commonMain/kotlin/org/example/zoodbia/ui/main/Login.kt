package org.example.zoodbia.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.navigation.NavHostController
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import zoodbia.composeapp.generated.resources.Res
import zoodbia.composeapp.generated.resources.*

@Composable
@Preview
fun LoginScreen(navHostController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Sign in",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        TextButton(
            onClick = {
                navHostController.navigate("SignUp")
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color(0xFF009959))) {
                    append("New to ZoodBia? ")
                }
                withStyle(style = SpanStyle(color = Color(0xFFEB5640))) {
                    append("Sign Up")
                }
            },
            fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)
            )
        }

        Button(
            onClick = { /* TODO: Handle facebook login button click */ },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Blue)
        ) {
            Image(
                painter = painterResource(Res.drawable.facebook_logo),
                contentDescription = "Facebook Logo",
                modifier = Modifier.width(36.dp).height(36.dp)
            )
            Text(
                text = "Continue with Facebook",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }

        Button(
            onClick = { /* TODO: Handle google login button click */ },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Blue)
        ) {
            Image(
                painter = painterResource(Res.drawable.google_logo),
                contentDescription = "Google Logo",
                modifier = Modifier.width(36.dp).height(36.dp)
            )

            Text(
                text = "Continue with Google",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) {
            Divider(
                color = Gray,
                thickness = 1.dp,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "or continue with email",
                modifier = Modifier.padding(horizontal = 8.dp),
                color = Gray,
                fontSize = 14.sp
            )
            Divider(
                color = Gray,
                thickness = 1.dp,
                modifier = Modifier.weight(1f)
            )
        }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = TextFieldBg,
                cursorColor = Black,
                focusedBorderColor = PrimaryTeal,
                unfocusedBorderColor = GrayBorder
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            trailingIcon = {
                val buttonText = if (passwordVisible)
                    "Hide"
                else
                    "Show"
                
                TextButton(
                    onClick = { passwordVisible = !passwordVisible }
                ) {
                    Text(
                        text = buttonText,
                        color = PrimaryTeal,
                        fontSize = 16.sp
                    )
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = TextFieldBg,
                cursorColor = Black,
                focusedBorderColor = PrimaryTeal,
                unfocusedBorderColor = GrayBorder
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Button(
            onClick = { /* TODO: Handle login button click */ },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryTeal)
        ) {
            Text(
                text = "Login",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }

        TextButton(
            onClick = {
                // TODO: Handle forgot password button click
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Forgot your password?",
                color = PrimaryTeal,
                fontSize = 16.sp
            )
        }
    }
}