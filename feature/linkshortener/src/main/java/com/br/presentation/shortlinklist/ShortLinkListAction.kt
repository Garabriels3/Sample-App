package com.br.presentation.shortlinklist

import com.br.presentation.baseviewmodel.UIAction

sealed class ShortLinkListAction : UIAction {
    object OnClickItem : ShortLinkListAction()
}