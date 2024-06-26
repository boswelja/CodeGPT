package ee.carlrobert.codegpt.actions

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.components.service
import com.intellij.openapi.project.DumbAwareAction
import ee.carlrobert.codegpt.settings.GeneralSettings
import ee.carlrobert.codegpt.settings.service.ServiceType
import ee.carlrobert.codegpt.settings.service.ServiceType.*
import ee.carlrobert.codegpt.settings.service.custom.CustomServiceSettings
import ee.carlrobert.codegpt.settings.service.llama.LlamaSettings
import ee.carlrobert.codegpt.settings.service.openai.OpenAISettings

abstract class CodeCompletionFeatureToggleActions(
    private val enableFeatureAction: Boolean
) : DumbAwareAction() {


    override fun actionPerformed(e: AnActionEvent) {
        when (GeneralSettings.getCurrentState().selectedService) {
            OPENAI -> OpenAISettings.getCurrentState().isCodeCompletionsEnabled = enableFeatureAction
            LLAMA_CPP -> LlamaSettings.getCurrentState().isCodeCompletionsEnabled = enableFeatureAction
            CUSTOM_OPENAI -> service<CustomServiceSettings>().state.codeCompletionSettings.codeCompletionsEnabled =
                enableFeatureAction
            ANTHROPIC,
            AZURE,
            YOU,
            null -> { /* no-op for these services */ }
        }
    }

    override fun update(e: AnActionEvent) {
        val selectedService = GeneralSettings.getCurrentState().selectedService
        val codeCompletionEnabled = isCodeCompletionsEnabled(selectedService)
        e.presentation.isEnabled = codeCompletionEnabled != enableFeatureAction
        e.presentation.isVisible = when (selectedService) {
            OPENAI,
            CUSTOM_OPENAI,
            LLAMA_CPP -> true
            ANTHROPIC,
            AZURE,
            YOU,
            null -> false
        }
    }

    override fun getActionUpdateThread(): ActionUpdateThread {
        return ActionUpdateThread.BGT
    }

    private fun isCodeCompletionsEnabled(serviceType: ServiceType): Boolean {
        return when (serviceType) {
            OPENAI -> OpenAISettings.getCurrentState().isCodeCompletionsEnabled
            CUSTOM_OPENAI -> service<CustomServiceSettings>().state.codeCompletionSettings.codeCompletionsEnabled
            LLAMA_CPP -> LlamaSettings.isCodeCompletionsPossible()
            ANTHROPIC,
            AZURE,
            YOU -> false
        }
    }
}

class EnableCompletionsAction : CodeCompletionFeatureToggleActions(true)

class DisableCompletionsAction : CodeCompletionFeatureToggleActions(false)
