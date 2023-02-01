package com.banuba.example.integrationapp

import android.app.Application
import android.util.Log
import com.banuba.sdk.token.storage.license.BanubaVideoEditor

class SampleApp : Application() {

    companion object {
        const val TAG = "BanubaVideoEditor"

        // Please set your license token for Banuba Video Editor SDK
        const val LICENSE_TOKEN = "kellpDWgCBKSb+AJnr117DRKfl6KoEI4M7W1GH3HmBnIrkvZ5UFkfyXBArfdDPJ+ruILLhDjOrIbQji4RQLoFqZ6zIvTZOOVAcdrM/qGgzdNiv1jLHq12mexlUOOm7mxDBeuccYFsN5AggiYDzhEQAD42AxMTvFOvMP+3tmO8h9yOzUbFjK4AlOFL0jWE703NrxoOfEs79Xbetm80HjOY1R7f1D8FbLsWRmOzSzS/E+5TKhriomqP8dRtoxZp2Pp2Hs/r+Id2/7WwqUx4N3+g75l5B1UwBsQv73urcNXlx4AeW+3p5opSq9L4TGg0+ZrRBvzffK5uUkZyaDTNmyca7Bxn4Xq9RAcNUtdijPckDB9Z1kGxCTsnEtYif1xEk0tEfAfowi5yzbo7N2XajwXILQu8/PoWoDpARNghaVXd49g3xsAyAud47PUeEBuUYfZPkyB4LZwEdDnfs13xxV9gpHgjFln48Wsgz9UKeM/7lvsoU98aWLae2ls2u8MthwIVy5ZHJRyrAypEqvOhn2eYcTEZVk4LVVBaQ=="

        const val ERR_SDK_NOT_INITIALIZED = "Banuba Video Editor SDK is not initialized: license token is unknown or incorrect.\nPlease check your license token or contact Banuba"
        const val ERR_LICENSE_REVOKED = "License is revoked or expired. Please contact Banuba https://www.banuba.com/faq/kb-tickets/new"
    }

    var videoEditor: BanubaVideoEditor? = null

    override fun onCreate() {
        super.onCreate()

        // Initialize Banuba Video Editor SDK
        videoEditor = BanubaVideoEditor.initialize(LICENSE_TOKEN)

        if (videoEditor == null) {
            // Token you provided is not correct - empty or truncated
            Log.e(TAG, ERR_SDK_NOT_INITIALIZED)
        } else {
            VideoEditorModule().initialize(this@SampleApp)
        }
    }
}
