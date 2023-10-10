package com.borja.android.jetpackcomposeinstagram

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TwitterScreen() {
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color(0xFF161026))
            .padding(16.dp)
    )
    {
        ImagenLogo(
            Modifier
                .size(55.dp)
                .clip(CircleShape)
        )
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            PrimeraLinea()
            TextoBody(
                "Programar en Kotlin es una experiencia gratificante." +
                        "Su sintaxis concisa simplifica la escritura de código." +
                        "Con su interoperabilidad con Java, es ideal para proyectos Android. " +
                        "Aprovecha la seguridad en tipos y la programación funcional." +
                        "¡Explora Kotlin y desbloquea un mundo de posibilidades!",
                Modifier.padding(bottom = 16.dp)
            )
            ImagenLogo(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(10))
            )
            FilaIconos()

        }
    }
}

@Composable
fun TuitDivider() {
    Divider(
        Modifier.padding(top=4.dp).height(10.5.dp).fillMaxWidth(),
        color = Color(0xFF7E8B98)
    )
}

@Composable
fun FilaIconos() {
    var chat by remember{ mutableStateOf(false) }
    var rt by remember{ mutableStateOf(false) }
    var like by remember{ mutableStateOf(false) }
    Row(Modifier.padding(top = 16.dp)) {
        SocialIcon(modifier = Modifier.weight(1f),
            unselectedIcon = {
                Icon(
                    painterResource(id = R.drawable.ic_chat),
                    contentDescription = "",
                    tint = Color(0xFF7E8B98)
                )
            },
        selectedIcon = {Icon(
            painterResource(id = R.drawable.ic_chat_filled),
            contentDescription = "",
            tint = Color(0xFF7E8B98)
        )},
        isSelected = chat){
            chat =!chat
        }

        SocialIcon(modifier = Modifier.weight(1f),
            unselectedIcon = {
                Icon(
                    painterResource(id = R.drawable.ic_rt),
                    contentDescription = "",
                    tint = Color(0xFF7E8B98)
                )
            },
            selectedIcon = {Icon(
                painterResource(id = R.drawable.ic_rt),
                contentDescription = "",
                tint = Color(0xFF00FF27)
            )},
            isSelected = rt){
            rt =!rt
        }


        SocialIcon(modifier = Modifier.weight(1f),
            unselectedIcon = {
                Icon(
                    painterResource(id = R.drawable.ic_like),
                    contentDescription = "",
                    tint = Color(0xFF7E8B98)
                )
            },
            selectedIcon = {Icon(
                painterResource(id = R.drawable.ic_like_filled),
                contentDescription = "",
                tint = Color(0xFFFF0000)
            )},
            isSelected = like){
            like =!like
        }

    }
}

@Composable
fun SocialIcon(
    modifier: Modifier,
    unselectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    isSelected: Boolean,
    onItemSelected: () -> Unit
) {
    val defaultValue = 1
    Row(
        modifier = modifier.clickable { onItemSelected() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isSelected) {
            selectedIcon()
        } else {
            unselectedIcon()
        }
        Text(
            text = if (isSelected) (defaultValue + 1).toString() else defaultValue.toString(),
            color = Color(0xFF7E8B98),
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun TextoBody(text: String, modifier: Modifier = Modifier) {
    Text(text = text, color = Color.White, modifier = modifier)
}

@Composable
fun PrimeraLinea() {
    Row(Modifier.fillMaxWidth()) {
        TextTile("Borchx", Modifier.padding(end = 8.dp))
        DefaultText(title = "@Borchx", Modifier.padding(end = 8.dp))
        DefaultText(title = "8h", Modifier.padding(end = 8.dp))
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painterResource(id = R.drawable.ic_dots),
            contentDescription = "Icono",
            tint = Color.White
        )
    }
}

@Composable
fun TextTile(title: String, modifier: Modifier = Modifier) {
    Text(text = title, color = Color.White, fontWeight = FontWeight.ExtraBold, modifier = modifier)
}

@Composable
fun DefaultText(title: String, modifier: Modifier = Modifier) {
    Text(text = title, color = Color.Gray, modifier = modifier)
}

@Composable
fun ImagenLogo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Profile logo",
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}
