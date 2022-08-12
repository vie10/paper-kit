package online.viestudio.paperkit.theme

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.minimessage.MiniMessage
import online.viestudio.paperkit.adventure.hexColor
import online.viestudio.paperkit.config.Comment

@Suppress("unused")
@Serializable
data class Appearance(
    @Comment(
        """
            The prefix of this plugin that appears in messages.
        """
    )
    val pluginPrefix: String = DEFAULT_PLUGIN_PREFIX,
    @Comment(
        """
           The primary color used in the plugin for the most part of common text.
           It's recommended to use not bright one.
           
           Supports only HEX format of colors.
        """
    )
    val primaryHex: String = DEFAULT_PRIMARY_HEX,
    @Comment(
        """
            The accent color used in the plugin for text to which player should give an attention.
            It's recommended to use a different to the primary color.
            
            Supports only HEX format of colors.
        """
    )
    val accentHex: String = DEFAULT_ACCENT_HEX,
    @Comment(
        """
            The warn color used in the plugin for text that warns player that something is wrong.
            It's recommended to use a different color than the others.
            
            Supports only HEX format of colors.
        """
    )
    val warnHex: String = DEFAULT_WARN_HEX,
    @Comment(
        """
            The error color used in the plugin for text that message about an error.
            It's recommended to use a different color than the others.
            
            Supports only HEX format of colors.
        """
    )
    val errorHex: String = DEFAULT_ERROR_HEX,
    @Comment(
        """
            The okay color used in the plugin for text that message about success.
            It's recommended to use a different color than the others.
            
            Supports only HEX format of colors.
        """
    )
    val okayHex: String = DEFAULT_OKAY_HEX,
) {

    @Transient
    val prefix: Component = MiniMessage.miniMessage().deserialize(pluginPrefix)

    @Transient
    val primary: TextColor = hexColor(primaryHex) ?: hexColor(DEFAULT_PRIMARY_HEX)!!

    @Transient
    val accent: TextColor = hexColor(accentHex) ?: hexColor(DEFAULT_ACCENT_HEX)!!

    @Transient
    val okay: TextColor = hexColor(accentHex) ?: hexColor(DEFAULT_OKAY_HEX)!!

    @Transient
    val warn: TextColor = hexColor(warnHex) ?: hexColor(DEFAULT_WARN_HEX)!!

    @Transient
    val error: TextColor = hexColor(errorHex) ?: hexColor(DEFAULT_ERROR_HEX)!!

    companion object {

        const val DEFAULT_PLUGIN_PREFIX = "<#B8B3E9>[<#F5F5F5>PaperKit<#B8B3E9>]"
        const val DEFAULT_PRIMARY_HEX = "#B8B3E9"
        const val DEFAULT_ACCENT_HEX = "#F5F5F5"
        const val DEFAULT_OKAY_HEX = "#5CFF5C"
        const val DEFAULT_WARN_HEX = "#f6cd61"
        const val DEFAULT_ERROR_HEX = "#fe8a71"
    }
}
