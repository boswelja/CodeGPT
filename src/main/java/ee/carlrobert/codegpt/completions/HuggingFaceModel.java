package ee.carlrobert.codegpt.completions;

import static java.lang.String.format;

import java.net.MalformedURLException;
import java.net.URL;

public enum HuggingFaceModel {

  CODE_LLAMA_7B_Q3(7, 3, "CodeLlama-7B-Instruct-GGUF"),
  CODE_LLAMA_7B_Q4(7, 4, "CodeLlama-7B-Instruct-GGUF"),
  CODE_LLAMA_7B_Q5(7, 5, "CodeLlama-7B-Instruct-GGUF"),
  CODE_LLAMA_13B_Q3(13, 3, "CodeLlama-13B-Instruct-GGUF"),
  CODE_LLAMA_13B_Q4(13, 4, "CodeLlama-13B-Instruct-GGUF"),
  CODE_LLAMA_13B_Q5(13, 5, "CodeLlama-13B-Instruct-GGUF"),
  CODE_LLAMA_34B_Q3(34, 3, "CodeLlama-34B-Instruct-GGUF"),
  CODE_LLAMA_34B_Q4(34, 4, "CodeLlama-34B-Instruct-GGUF"),
  CODE_LLAMA_34B_Q5(34, 5, "CodeLlama-34B-Instruct-GGUF"),

  CODE_BOOGA_34B_Q3(34, 3, "CodeBooga-34B-v0.1-GGUF"),
  CODE_BOOGA_34B_Q4(34, 4, "CodeBooga-34B-v0.1-GGUF"),
  CODE_BOOGA_34B_Q5(34, 5, "CodeBooga-34B-v0.1-GGUF"),

  DEEPSEEK_CODER_1_3B_Q3(1, 3, "deepseek-coder-1.3b-instruct-GGUF", 0.705),
  DEEPSEEK_CODER_1_3B_Q4(1, 4, "deepseek-coder-1.3b-instruct-GGUF", 0.874),
  DEEPSEEK_CODER_1_3B_Q5(1, 5, "deepseek-coder-1.3b-instruct-GGUF", 1.0),
  DEEPSEEK_CODER_6_7B_Q3(7, 3, "deepseek-coder-6.7b-instruct-GGUF"),
  DEEPSEEK_CODER_6_7B_Q4(7, 4, "deepseek-coder-6.7b-instruct-GGUF"),
  DEEPSEEK_CODER_6_7B_Q5(7, 5, "deepseek-coder-6.7b-instruct-GGUF"),
  DEEPSEEK_CODER_33B_Q3(33, 3, "deepseek-coder-33b-instruct-GGUF", 16.1),
  DEEPSEEK_CODER_33B_Q4(33, 4, "deepseek-coder-33b-instruct-GGUF", 19.9),
  DEEPSEEK_CODER_33B_Q5(33, 5, "deepseek-coder-33b-instruct-GGUF", 23.5),

  PHIND_CODE_LLAMA_34B_Q3(34, 3, "Phind-CodeLlama-34B-v2-GGUF"),
  PHIND_CODE_LLAMA_34B_Q4(34, 4, "Phind-CodeLlama-34B-v2-GGUF"),
  PHIND_CODE_LLAMA_34B_Q5(34, 5, "Phind-CodeLlama-34B-v2-GGUF"),

  WIZARD_CODER_PYTHON_7B_Q3(7, 3, "WizardCoder-Python-7B-V1.0-GGUF"),
  WIZARD_CODER_PYTHON_7B_Q4(7, 4, "WizardCoder-Python-7B-V1.0-GGUF"),
  WIZARD_CODER_PYTHON_7B_Q5(7, 5, "WizardCoder-Python-7B-V1.0-GGUF"),
  WIZARD_CODER_PYTHON_13B_Q3(13, 3, "WizardCoder-Python-13B-V1.0-GGUF"),
  WIZARD_CODER_PYTHON_13B_Q4(13, 4, "WizardCoder-Python-13B-V1.0-GGUF"),
  WIZARD_CODER_PYTHON_13B_Q5(13, 5, "WizardCoder-Python-13B-V1.0-GGUF"),
  WIZARD_CODER_PYTHON_34B_Q3(34, 3, "WizardCoder-Python-34B-V1.0-GGUF"),
  WIZARD_CODER_PYTHON_34B_Q4(34, 4, "WizardCoder-Python-34B-V1.0-GGUF"),
  WIZARD_CODER_PYTHON_34B_Q5(34, 5, "WizardCoder-Python-34B-V1.0-GGUF"),

  LLAMA_3_8B_IQ3_M(8, 3, "Meta-Llama-3-8B-Instruct-IQ3_M.gguf", "lmstudio-community", 3.78),
  LLAMA_3_8B_Q4_K_M(8, 4, "Meta-Llama-3-8B-Instruct-Q4_K_M.gguf", "lmstudio-community", 4.92),
  LLAMA_3_8B_Q5_K_M(8, 5, "Meta-Llama-3-8B-Instruct-Q5_K_M.gguf", "lmstudio-community", 5.73),
  LLAMA_3_8B_Q6_K(8, 6, "Meta-Llama-3-8B-Instruct-Q6_K.gguf", "lmstudio-community", 6.6),
  LLAMA_3_8B_Q8_0(8, 8, "Meta-Llama-3-8B-Instruct-Q8_0.gguf", "lmstudio-community", 8.54),
  LLAMA_3_70B_IQ1(70, 1, "Meta-Llama-3-70B-Instruct-IQ1_M.gguf", "lmstudio-community", 16.8),
  LLAMA_3_70B_IQ2_XS(70, 2, "Meta-Llama-3-70B-Instruct-IQ2_XS.gguf", "lmstudio-community", 21.1),
  LLAMA_3_70B_Q4_K_M(70, 4, "Meta-Llama-3-70B-Instruct-Q4_K_M.gguf", "lmstudio-community", 42.5),

  PHI_3_3_8B_4K_IQ4_NL(4, 4, "Phi-3-mini-4k-instruct-IQ4_NL.gguf", "lmstudio-community", 2.18),
  PHI_3_3_8B_4K_Q5_K_M(4, 5, "Phi-3-mini-4k-instruct-Q5_K_M.gguf", "lmstudio-community", 2.64),
  PHI_3_3_8B_4K_Q5_K_S(4, 5, "Phi-3-mini-4k-instruct-Q5_K_S.gguf", "lmstudio-community", 2.82),
  PHI_3_3_8B_4K_Q6_K(4, 6, "Phi-3-mini-4k-instruct-Q6_K.gguf", "lmstudio-community", 3.14),
  PHI_3_3_8B_4K_Q8_0(4, 8, "Phi-3-mini-4k-instruct-Q8_0.gguf", "lmstudio-community", 4.06),
  PHI_3_3_8B_4K_FP16(4, 16, "Phi-3-mini-4k-instruct-fp16.gguf", "lmstudio-community", 7.64),

  CODE_GEMMA_7B_IQ1_S(7, 1, "codegemma-7b-it-IQ1_S.gguf", "lmstudio-community", 2.16),
  CODE_GEMMA_7B_IQ1_M(7, 1, "codegemma-7b-it-IQ1_M.gguf", "lmstudio-community", 2.32),
  CODE_GEMMA_7B_IQ2_XXS(7, 2, "codegemma-7b-it-IQ2_XXS.gguf", "lmstudio-community", 2.59),
  CODE_GEMMA_7B_IQ2_XS(7, 2, "codegemma-7b-it-IQ2_XS.gguf", "lmstudio-community", 2.81),
  CODE_GEMMA_7B_IQ2_S(7, 2, "codegemma-7b-it-IQ2_S.gguf", "lmstudio-community", 2.92),
  CODE_GEMMA_7B_IQ2_M(7, 2, "codegemma-7b-it-IQ2_M.gguf", "lmstudio-community", 3.13),
  CODE_GEMMA_7B_Q2_K(7, 2, "codegemma-7b-it-Q2_K.gguf", "lmstudio-community", 3.48),
  CODE_GEMMA_7B_IQ3_XXS(7, 3, "codegemma-7b-it-IQ3_XXS.gguf", "lmstudio-community", 3.49),
  CODE_GEMMA_7B_IQ3_XS(7, 3, "codegemma-7b-it-IQ3_XS.gguf", "lmstudio-community", 3.80),
  CODE_GEMMA_7B_IQ3_S(7, 3, "codegemma-7b-it-IQ3_S.gguf", "lmstudio-community", 3.98),
  CODE_GEMMA_7B_Q3_K_S(7, 3, "codegemma-7b-it-Q3_K_S.gguf", "lmstudio-community", 3.98),
  CODE_GEMMA_7B_IQ3_M(7, 3, "codegemma-7b-it-IQ3_M.gguf", "lmstudio-community", 4.11),
  CODE_GEMMA_7B_Q3_K_M(7, 3, "codegemma-7b-it-Q3_K_M.gguf", "lmstudio-community", 4.37),
  CODE_GEMMA_7B_Q3_K_L(7, 3, "codegemma-7b-it-Q3_K_L.gguf", "lmstudio-community", 4.71),
  CODE_GEMMA_7B_IQ4_XS(7, 4, "codegemma-7b-it-IQ4_XS.gguf", "lmstudio-community", 4.77),
  CODE_GEMMA_7B_IQ4_NL(7, 4, "codegemma-7b-it-IQ4_NL.gguf", "lmstudio-community", 5.01),
  CODE_GEMMA_7B_Q4_K_S(7, 4, "codegemma-7b-it-Q4_K_S.gguf", "lmstudio-community", 5.05),
  CODE_GEMMA_7B_Q4_K_M(7, 4, "codegemma-7b-it-Q4_K_M.gguf", "lmstudio-community", 5.33),
  CODE_GEMMA_7B_Q5_K_S(7, 5, "codegemma-7b-it-Q5_K_S.gguf", "lmstudio-community", 5.98),
  CODE_GEMMA_7B_Q5_K_M(7, 5, "codegemma-7b-it-Q5_K_M.gguf", "lmstudio-community", 6.14),
  CODE_GEMMA_7B_Q6_K(7, 6, "codegemma-7b-it-Q6_K.gguf", "lmstudio-community", 7.01),
  CODE_GEMMA_7B_Q8_0(7, 8, "codegemma-7b-it-Q8_0.gguf", "lmstudio-community", 9.08),
  ;

  private final int parameterSize;
  private final int quantization;
  private final String modelName;
  private final String user;
  private final Double downloadSize; // in GB

  HuggingFaceModel(int parameterSize, int quantization, String modelName) {
    this(parameterSize, quantization, modelName, "TheBloke", null);
  }

  HuggingFaceModel(int parameterSize, int quantization, String modelName, Double downloadSize) {
    this(parameterSize, quantization, modelName, "TheBloke", downloadSize);
  }

  HuggingFaceModel(int parameterSize, int quantization, String modelName, String user,
                   Double downloadSize) {
    this.parameterSize = parameterSize;
    this.quantization = quantization;
    this.modelName = modelName;
    this.user = user;
    this.downloadSize = downloadSize;
  }

  public int getParameterSize() {
    return parameterSize;
  }

  public int getQuantization() {
    return quantization;
  }

  public String getCode() {
    return name();
  }

  public Double getDownloadSize() {
    return downloadSize;
  }

  public String getFileName() {
    if ("TheBloke".equals(user)) {
      return modelName.toLowerCase().replace("-gguf", format(".Q%d_K_M.gguf", quantization));
    }
    return modelName;
  }

  public URL getFileURL() {
    try {
      return new URL(
          "https://huggingface.co/%s/%s/resolve/main/%s".formatted(user, getDirectory(), getFileName()));
    } catch (MalformedURLException ex) {
      throw new RuntimeException(ex);
    }
  }

  public URL getHuggingFaceURL() {
    try {
      return new URL("https://huggingface.co/%s/%s".formatted(user, getDirectory()));
    } catch (MalformedURLException ex) {
      throw new RuntimeException(ex);
    }
  }

  private String getDirectory() {
    if ("lmstudio-community".equals(user)) {
      // Meta-Llama-3-8B-Instruct-Q4_K_M.gguf -> Meta-Llama-3-8B-Instruct-GGUF
      return modelName.replaceFirst("-[^.-]+\\.gguf$", "-GGUF");
    }
    return modelName;
  }

  @Override
  public String toString() {
    return format("%d-bit precision", quantization);
  }
}
