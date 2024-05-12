package com.example.languagearm

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage

object SB
    {
        val supaBase = createSupabaseClient(
            supabaseUrl = "https://capkoptvklizkewzohvm.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNhcGtvcHR2a2xpemtld3pvaHZtIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDg3ODUzNDUsImV4cCI6MjAyNDM2MTM0NX0.qi330ccqUCMr17_dzLnRRH5cz2PT9rV1RB9QJhbOsx4"
        ) {
            install(Auth)
            install(Postgrest)
            install(Storage)
            //install other modules
            }

fun client(): SupabaseClient {
    return supaBase;
}


}