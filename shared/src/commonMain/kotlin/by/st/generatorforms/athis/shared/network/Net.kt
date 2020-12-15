package by.st.generatorforms.athis.shared.network

import by.st.generatorforms.athis.shared.model.Currency
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json


class MyNet{
    private val httpClient = HttpClient {
        install(JsonFeature){
            val json = kotlinx.serialization.json.Json{ignoreUnknownKeys = true}
            serializer = KotlinxSerializer(json)
        }
    }

    suspend fun getAllLaunches(): List<Currency> {
        return httpClient.get(LAUNCHES_ENDPOINT)
    }

    companion object {
        private const val LAUNCHES_ENDPOINT = "https://www.nbrb.by/api/exrates/rates?periodicity=0"
    }
}
