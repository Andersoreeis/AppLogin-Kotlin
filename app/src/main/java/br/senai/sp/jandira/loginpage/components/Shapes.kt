package br.senai.sp.jandira.loginpage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun topShape() {
    Box(
        modifier = Modifier
            .width(120.dp)
            .fillMaxHeight()
            .background(
                Color(207, 6, 240, ),
                shape = RoundedCornerShape(bottomStart = 16.dp)
            )
    )

}
@Preview
@Composable
fun topShapePreview(){
    topShape()
}
@Composable
fun bottomShape(){
    Box(
        modifier = Modifier
            .width(120.dp)
            .height(40.dp)
            .background(
                Color(207, 6, 240),
                shape = RoundedCornerShape(topEnd = 16.dp)
            )
    )
}

@Preview
@Composable
fun bottomShapePreview(){
    bottomShape()
}