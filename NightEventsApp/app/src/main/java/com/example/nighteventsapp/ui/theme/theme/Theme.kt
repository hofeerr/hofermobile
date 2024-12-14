package com.example.nighteventsapp.ui.theme.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFE91E63),  // Barbie Pink
    secondary = Color(0xFFF5A6D2),  // Light Pink
    tertiary = Color(0xFFFC72A1),  // Bright Pink
    background = Color(0xFF121212),  // Dark background
    surface = Color(0xFF1E1E1E),  // Dark surface
    onPrimary = Color.White,  // White text on primary
    onSecondary = Color.White,  // White text on secondary
    onTertiary = Color.White,  // White text on tertiary
    onBackground = Color.White,  // White text on background
    onSurface = Color.White  // White text on surface
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFE91E63),  // Barbie Pink
    secondary = Color(0xFFF5A6D2),  // Light Pink
    tertiary = Color(0xFFFC72A1),  // Bright Pink
    background = Color(0xFFFFFBFE),  // Light background
    surface = Color(0xFFFFFBFE),  // Light surface
    onPrimary = Color.Black,  // Black text on primary
    onSecondary = Color.Black,  // Black text on secondary
    onTertiary = Color.Black,  // Black text on tertiary
    onBackground = Color.Black,  // Black text on background
    onSurface = Color.Black  // Black text on surface
)

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */

@Composable
fun NightEventsAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}