# Padrão Proxy com Controle de Acesso em Java

## 📖 Sobre o Padrão Proxy

O padrão **Proxy** é um padrão estrutural que atua como um intermediário ou substituto para outro objeto, fornecendo uma interface idêntica. Ele é usado para controlar o acesso ao objeto real, adicionando funcionalidades como:

- **Controle de acesso**: Restringir ou autorizar o uso de recursos.
- **Caching**: Guardar resultados de operações caras para reutilização.
- **Lazy initialization**: Carregar objetos de forma atrasada para economizar recursos.
- **Monitoramento**: Adicionar lógica de auditoria ou registro de atividades.

---

## 💡 Situação Real Implementada

Neste projeto, usamos o padrão Proxy para implementar controle de acesso em um serviço de streaming de vídeos. Apenas usuários com assinatura **Premium** podem acessar determinados vídeos. Caso o usuário seja **Básico**, o acesso ao conteúdo restrito será bloqueado.

---

## 🛠 Estrutura do Projeto

### 1. Interface `VideoService`
Define as operações do serviço de vídeos.

```java
public interface VideoService {
    void playVideo(String videoName);
}
```

### 2. Implementação Real `RealVideoService`
Representa o serviço real responsável por tocar os vídeos.

```java
public class RealVideoService implements VideoService {
    @Override
    public void playVideo(String videoName) {
        System.out.println("Playing video: " + videoName);
    }
}
```

### 3. Proxy `VideoServiceProxy`
Controla o acesso ao serviço real baseado no tipo de usuário.

```java
public class VideoServiceProxy implements VideoService {
    private RealVideoService realVideoService;
    private String userType;

    public VideoServiceProxy(String userType) {
        this.realVideoService = new RealVideoService();
        this.userType = userType;
    }

    @Override
    public void playVideo(String videoName) {
        if ("Premium".equalsIgnoreCase(userType)) {
            realVideoService.playVideo(videoName);
        } else {
            System.out.println("Access denied. Upgrade to Premium to watch this video.");
        }
    }
}
```

### 4. Teste da Funcionalidade
Usamos JUnit para validar o comportamento do proxy.

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VideoServiceProxyTest {

    @Test
    public void testPremiumUserAccess() {
        VideoService proxy = new VideoServiceProxy("Premium");
        proxy.playVideo("Exclusive Movie");
    }

    @Test
    public void testBasicUserAccess() {
        VideoService proxy = new VideoServiceProxy("Basic");
        proxy.playVideo("Exclusive Movie");
    }
}
```

---

## ✅ Como Testar o Projeto

1. Clone ou copie este repositório para sua máquina local.
2. Compile os arquivos Java usando um compilador como `javac` ou sua IDE preferida.
3. Execute os testes com JUnit para validar o comportamento do Proxy.

---

## 🚀 Benefícios do Padrão Proxy

- **Segurança**: Controle de acesso robusto para proteger recursos.
- **Flexibilidade**: Adicionar lógica sem modificar a implementação real.
- **Escalabilidade**: Permite implementar mecanismos de caching ou carregamento atrasado.

---

## 📌 Conclusão

O padrão Proxy foi essencial para separar a lógica de controle de acesso do serviço real, tornando o código mais modular e fácil de manter. Essa abordagem é amplamente utilizada em sistemas que requerem restrições de acesso, auditoria ou otimização de desempenho.
