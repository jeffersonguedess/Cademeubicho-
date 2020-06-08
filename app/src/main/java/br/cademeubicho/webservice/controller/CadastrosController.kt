package br.cademeubicho.webservice.controller

import br.cademeubicho.model.PostCadastro
import br.cademeubicho.model.Status
import br.cademeubicho.model.Usuario
import br.cademeubicho.webservice.api.RetrofitClient
import retrofit2.Response


class CadastrosController {
    val statusResponse = Status("", "")

    fun cadastroUsuario(user: Usuario) : Status {
        var response : Response<Status>
        response = RetrofitClient.instance.cadastrarUsuario(
            user.uidFirebase, user.nomeUsuario,
            user.distanciaFeed, user.emailUsuario,
            user.numeroCelular, user.dddCelular,
            user.idFacebook
        ).execute();

        return returnStatusResponse(response)

    }

    fun atualizaUsuario(user : Usuario) : Status {
        var response : Response<Status>
        response = RetrofitClient.instance.atualizaUsuario(
            user.uidFirebase, user.nomeUsuario,
            user.distanciaFeed, user.emailUsuario,
            user.numeroCelular, user.dddCelular
        ).execute();

        return returnStatusResponse(response)
    }


    fun cadastrarPost(post : PostCadastro) : Status {
        var response : Response<Status>
        response = RetrofitClient.instance.cadastrarPost(
            post.uidFirebase, post.porteAnimal,
            post.tipoAnimal, post.nomeAnimal,
            post.racaAnimal, post.idadeAnimal,
            post.corAnimal, post.recompensa,
            post.longitude, post.latitude,
            post.imagens
        ).execute();

        return returnStatusResponse(response)

    }

    fun atualizarPost(post : PostCadastro) : Status {
        var response : Response<Status>
        response = RetrofitClient.instance.atualizaPost(
            post.uidFirebase, post.porteAnimal,
            post.tipoAnimal, post.nomeAnimal,
            post.racaAnimal, post.idadeAnimal,
            post.corAnimal, post.recompensa,
            post.longitude, post.latitude,
            post.imagens
        ).execute();

        return returnStatusResponse(response)

    }




    fun desativaPost(uidFirebase : String) : Status {
        var response : Response<Status>
        response = RetrofitClient.instance.desativarPost( uidFirebase ).execute();

        return returnStatusResponse(response)
    }



    private fun returnStatusResponse(response : Response<Status>) : Status {
        if (response.isSuccessful()) {
            statusResponse.statusMensagem = response.body()!!.statusMensagem
            statusResponse.retorno = response.body()!!.retorno
        }
        return statusResponse

    }
}





