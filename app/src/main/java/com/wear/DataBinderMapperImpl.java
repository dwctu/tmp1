package com.wear;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.lovense.wear.R;
import com.wear.databinding.ActivityChatBuildBindingImpl;
import com.wear.databinding.ActivityChatNewSelectBindingImpl;
import com.wear.databinding.ActivityConnectionsBlockBindingImpl;
import com.wear.databinding.ActivityNewGameModeBindingImpl;
import com.wear.databinding.ActivityNewToyBindingImpl;
import com.wear.databinding.ActivityOnlineStatusBindingImpl;
import com.wear.databinding.ActivityRouletteChatEndBindingImpl;
import com.wear.databinding.ActivityThirdBindAccountBindingImpl;
import com.wear.databinding.ActivityToyFunctionBindingImpl;
import com.wear.databinding.DialogFragmentChatActionMenuBindingImpl;
import com.wear.databinding.DialogFragmentReportActionMenuBindingImpl;
import com.wear.databinding.DialogFragmentRouletteFilterBindingImpl;
import com.wear.databinding.DialogFragmentRouletteSettingsBindingImpl;
import com.wear.databinding.DialogGuideVideoBindingImpl;
import com.wear.databinding.FragmentInviteUserRequestBindingImpl;
import com.wear.databinding.FragmentLongUserActionMenuBindingImpl;
import com.wear.databinding.FragmentLongUserActionMenuConfirmBindingImpl;
import com.wear.databinding.FragmentRouletteHomeBindingImpl;
import com.wear.databinding.FragmentRouletteMatchSuccessBindingImpl;
import com.wear.databinding.FragmentRouletteResultBindingImpl;
import com.wear.databinding.FragmentRouletteWelcomeBindingImpl;
import com.wear.databinding.HeadOnlineStatusUserSelecedBindingImpl;
import com.wear.databinding.HeaderOnlineStatusBindingImpl;
import com.wear.databinding.ItemChatActionMenuBindingImpl;
import com.wear.databinding.ItemChatAudioLeftBindingImpl;
import com.wear.databinding.ItemChatAudioRightBindingImpl;
import com.wear.databinding.ItemChatMenuBindingImpl;
import com.wear.databinding.ItemChatSystemBindingImpl;
import com.wear.databinding.ItemChatTextLeftBindingImpl;
import com.wear.databinding.ItemChatTextRightBindingImpl;
import com.wear.databinding.ItemConnectionRequestBindingImpl;
import com.wear.databinding.ItemConnectionsBlockBindingImpl;
import com.wear.databinding.ItemConnectionsGroupBindingImpl;
import com.wear.databinding.ItemConnectionsLetterBindingImpl;
import com.wear.databinding.ItemConnectionsUserBindingImpl;
import com.wear.databinding.ItemGroupManagerInvitationBindingImpl;
import com.wear.databinding.ItemGroupManagerMemberBindingImpl;
import com.wear.databinding.ItemManagerGroupHeadBindingImpl;
import com.wear.databinding.ItemOnlineStatusUserBindingImpl;
import com.wear.databinding.ItemOnlineStatusUserSelectBindingImpl;
import com.wear.databinding.ItemReportActionMenuBindingImpl;
import com.wear.databinding.ItemReportChooseImgBindingImpl;
import com.wear.databinding.ItemRouletteSelectedBindingImpl;
import com.wear.databinding.ItemRouletteToyBindingImpl;
import com.wear.databinding.ViewMultiVelvoPanelBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    public static final SparseIntArray a;

    public static class a {
        public static final SparseArray<String> a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(28);
            a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "bean");
            sparseArray.put(2, "emojisType");
            sparseArray.put(3, "emojisUtils");
            sparseArray.put(4, "inputText");
            sparseArray.put(5, "inviteRequestInfo");
            sparseArray.put(6, "isAgreed");
            sparseArray.put(7, "isExpand");
            sparseArray.put(8, "isHighLight");
            sparseArray.put(9, "isSelectMode");
            sparseArray.put(10, "item");
            sparseArray.put(11, "keyword");
            sparseArray.put(12, "letter");
            sparseArray.put(13, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            sparseArray.put(14, "listeners");
            sparseArray.put(15, "m");
            sparseArray.put(16, "message");
            sparseArray.put(17, "nickname");
            sparseArray.put(18, "onlineStatus");
            sparseArray.put(19, "setting");
            sparseArray.put(20, "settings");
            sparseArray.put(21, "size");
            sparseArray.put(22, "state");
            sparseArray.put(23, "time");
            sparseArray.put(24, "type");
            sparseArray.put(25, "user");
            sparseArray.put(26, "userId");
            sparseArray.put(27, "vm");
        }
    }

    public static class b {
        public static final HashMap<String, Integer> a;

        static {
            HashMap<String, Integer> map = new HashMap<>(45);
            a = map;
            map.put("layout/activity_chat_build_0", Integer.valueOf(R.layout.activity_chat_build));
            map.put("layout/activity_chat_new_select_0", Integer.valueOf(R.layout.activity_chat_new_select));
            map.put("layout/activity_connections_block_0", Integer.valueOf(R.layout.activity_connections_block));
            map.put("layout/activity_new_game_mode_0", Integer.valueOf(R.layout.activity_new_game_mode));
            map.put("layout/activity_new_toy_0", Integer.valueOf(R.layout.activity_new_toy));
            map.put("layout/activity_online_status_0", Integer.valueOf(R.layout.activity_online_status));
            map.put("layout/activity_roulette_chat_end_0", Integer.valueOf(R.layout.activity_roulette_chat_end));
            map.put("layout/activity_third_bind_account_0", Integer.valueOf(R.layout.activity_third_bind_account));
            map.put("layout/activity_toy_function_0", Integer.valueOf(R.layout.activity_toy_function));
            map.put("layout/dialog_fragment_chat_action_menu_0", Integer.valueOf(R.layout.dialog_fragment_chat_action_menu));
            map.put("layout/dialog_fragment_report_action_menu_0", Integer.valueOf(R.layout.dialog_fragment_report_action_menu));
            map.put("layout/dialog_fragment_roulette_filter_0", Integer.valueOf(R.layout.dialog_fragment_roulette_filter));
            map.put("layout/dialog_fragment_roulette_settings_0", Integer.valueOf(R.layout.dialog_fragment_roulette_settings));
            map.put("layout/dialog_guide_video_0", Integer.valueOf(R.layout.dialog_guide_video));
            map.put("layout/fragment_invite_user_request_0", Integer.valueOf(R.layout.fragment_invite_user_request));
            map.put("layout/fragment_long_user_action_menu_0", Integer.valueOf(R.layout.fragment_long_user_action_menu));
            map.put("layout/fragment_long_user_action_menu_confirm_0", Integer.valueOf(R.layout.fragment_long_user_action_menu_confirm));
            map.put("layout/fragment_roulette_home_0", Integer.valueOf(R.layout.fragment_roulette_home));
            map.put("layout/fragment_roulette_match_success_0", Integer.valueOf(R.layout.fragment_roulette_match_success));
            map.put("layout/fragment_roulette_result_0", Integer.valueOf(R.layout.fragment_roulette_result));
            map.put("layout/fragment_roulette_welcome_0", Integer.valueOf(R.layout.fragment_roulette_welcome));
            map.put("layout/head_online_status_user_seleced_0", Integer.valueOf(R.layout.head_online_status_user_seleced));
            map.put("layout/header_online_status_0", Integer.valueOf(R.layout.header_online_status));
            map.put("layout/item_chat_action_menu_0", Integer.valueOf(R.layout.item_chat_action_menu));
            map.put("layout/item_chat_audio_left_0", Integer.valueOf(R.layout.item_chat_audio_left));
            map.put("layout/item_chat_audio_right_0", Integer.valueOf(R.layout.item_chat_audio_right));
            map.put("layout/item_chat_menu_0", Integer.valueOf(R.layout.item_chat_menu));
            map.put("layout/item_chat_system_0", Integer.valueOf(R.layout.item_chat_system));
            map.put("layout/item_chat_text_left_0", Integer.valueOf(R.layout.item_chat_text_left));
            map.put("layout/item_chat_text_right_0", Integer.valueOf(R.layout.item_chat_text_right));
            map.put("layout/item_connection_request_0", Integer.valueOf(R.layout.item_connection_request));
            map.put("layout/item_connections_block_0", Integer.valueOf(R.layout.item_connections_block));
            map.put("layout/item_connections_group_0", Integer.valueOf(R.layout.item_connections_group));
            map.put("layout/item_connections_letter_0", Integer.valueOf(R.layout.item_connections_letter));
            map.put("layout/item_connections_user_0", Integer.valueOf(R.layout.item_connections_user));
            map.put("layout/item_group_manager_invitation_0", Integer.valueOf(R.layout.item_group_manager_invitation));
            map.put("layout/item_group_manager_member_0", Integer.valueOf(R.layout.item_group_manager_member));
            map.put("layout/item_manager_group_head_0", Integer.valueOf(R.layout.item_manager_group_head));
            map.put("layout/item_online_status_user_0", Integer.valueOf(R.layout.item_online_status_user));
            map.put("layout/item_online_status_user_select_0", Integer.valueOf(R.layout.item_online_status_user_select));
            map.put("layout/item_report_action_menu_0", Integer.valueOf(R.layout.item_report_action_menu));
            map.put("layout/item_report_choose_img_0", Integer.valueOf(R.layout.item_report_choose_img));
            map.put("layout/item_roulette_selected_0", Integer.valueOf(R.layout.item_roulette_selected));
            map.put("layout/item_roulette_toy_0", Integer.valueOf(R.layout.item_roulette_toy));
            map.put("layout/view_multi_velvo_panel_0", Integer.valueOf(R.layout.view_multi_velvo_panel));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(45);
        a = sparseIntArray;
        sparseIntArray.put(R.layout.activity_chat_build, 1);
        sparseIntArray.put(R.layout.activity_chat_new_select, 2);
        sparseIntArray.put(R.layout.activity_connections_block, 3);
        sparseIntArray.put(R.layout.activity_new_game_mode, 4);
        sparseIntArray.put(R.layout.activity_new_toy, 5);
        sparseIntArray.put(R.layout.activity_online_status, 6);
        sparseIntArray.put(R.layout.activity_roulette_chat_end, 7);
        sparseIntArray.put(R.layout.activity_third_bind_account, 8);
        sparseIntArray.put(R.layout.activity_toy_function, 9);
        sparseIntArray.put(R.layout.dialog_fragment_chat_action_menu, 10);
        sparseIntArray.put(R.layout.dialog_fragment_report_action_menu, 11);
        sparseIntArray.put(R.layout.dialog_fragment_roulette_filter, 12);
        sparseIntArray.put(R.layout.dialog_fragment_roulette_settings, 13);
        sparseIntArray.put(R.layout.dialog_guide_video, 14);
        sparseIntArray.put(R.layout.fragment_invite_user_request, 15);
        sparseIntArray.put(R.layout.fragment_long_user_action_menu, 16);
        sparseIntArray.put(R.layout.fragment_long_user_action_menu_confirm, 17);
        sparseIntArray.put(R.layout.fragment_roulette_home, 18);
        sparseIntArray.put(R.layout.fragment_roulette_match_success, 19);
        sparseIntArray.put(R.layout.fragment_roulette_result, 20);
        sparseIntArray.put(R.layout.fragment_roulette_welcome, 21);
        sparseIntArray.put(R.layout.head_online_status_user_seleced, 22);
        sparseIntArray.put(R.layout.header_online_status, 23);
        sparseIntArray.put(R.layout.item_chat_action_menu, 24);
        sparseIntArray.put(R.layout.item_chat_audio_left, 25);
        sparseIntArray.put(R.layout.item_chat_audio_right, 26);
        sparseIntArray.put(R.layout.item_chat_menu, 27);
        sparseIntArray.put(R.layout.item_chat_system, 28);
        sparseIntArray.put(R.layout.item_chat_text_left, 29);
        sparseIntArray.put(R.layout.item_chat_text_right, 30);
        sparseIntArray.put(R.layout.item_connection_request, 31);
        sparseIntArray.put(R.layout.item_connections_block, 32);
        sparseIntArray.put(R.layout.item_connections_group, 33);
        sparseIntArray.put(R.layout.item_connections_letter, 34);
        sparseIntArray.put(R.layout.item_connections_user, 35);
        sparseIntArray.put(R.layout.item_group_manager_invitation, 36);
        sparseIntArray.put(R.layout.item_group_manager_member, 37);
        sparseIntArray.put(R.layout.item_manager_group_head, 38);
        sparseIntArray.put(R.layout.item_online_status_user, 39);
        sparseIntArray.put(R.layout.item_online_status_user_select, 40);
        sparseIntArray.put(R.layout.item_report_action_menu, 41);
        sparseIntArray.put(R.layout.item_report_choose_img, 42);
        sparseIntArray.put(R.layout.item_roulette_selected, 43);
        sparseIntArray.put(R.layout.item_roulette_toy, 44);
        sparseIntArray.put(R.layout.view_multi_velvo_panel, 45);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i) {
        return a.a.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = a.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i2) {
            case 1:
                if ("layout/activity_chat_build_0".equals(tag)) {
                    return new ActivityChatBuildBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_chat_build is invalid. Received: " + tag);
            case 2:
                if ("layout/activity_chat_new_select_0".equals(tag)) {
                    return new ActivityChatNewSelectBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_chat_new_select is invalid. Received: " + tag);
            case 3:
                if ("layout/activity_connections_block_0".equals(tag)) {
                    return new ActivityConnectionsBlockBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_connections_block is invalid. Received: " + tag);
            case 4:
                if ("layout/activity_new_game_mode_0".equals(tag)) {
                    return new ActivityNewGameModeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_new_game_mode is invalid. Received: " + tag);
            case 5:
                if ("layout/activity_new_toy_0".equals(tag)) {
                    return new ActivityNewToyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_new_toy is invalid. Received: " + tag);
            case 6:
                if ("layout/activity_online_status_0".equals(tag)) {
                    return new ActivityOnlineStatusBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_online_status is invalid. Received: " + tag);
            case 7:
                if ("layout/activity_roulette_chat_end_0".equals(tag)) {
                    return new ActivityRouletteChatEndBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_roulette_chat_end is invalid. Received: " + tag);
            case 8:
                if ("layout/activity_third_bind_account_0".equals(tag)) {
                    return new ActivityThirdBindAccountBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_third_bind_account is invalid. Received: " + tag);
            case 9:
                if ("layout/activity_toy_function_0".equals(tag)) {
                    return new ActivityToyFunctionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_toy_function is invalid. Received: " + tag);
            case 10:
                if ("layout/dialog_fragment_chat_action_menu_0".equals(tag)) {
                    return new DialogFragmentChatActionMenuBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_fragment_chat_action_menu is invalid. Received: " + tag);
            case 11:
                if ("layout/dialog_fragment_report_action_menu_0".equals(tag)) {
                    return new DialogFragmentReportActionMenuBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_fragment_report_action_menu is invalid. Received: " + tag);
            case 12:
                if ("layout/dialog_fragment_roulette_filter_0".equals(tag)) {
                    return new DialogFragmentRouletteFilterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_fragment_roulette_filter is invalid. Received: " + tag);
            case 13:
                if ("layout/dialog_fragment_roulette_settings_0".equals(tag)) {
                    return new DialogFragmentRouletteSettingsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_fragment_roulette_settings is invalid. Received: " + tag);
            case 14:
                if ("layout/dialog_guide_video_0".equals(tag)) {
                    return new DialogGuideVideoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_guide_video is invalid. Received: " + tag);
            case 15:
                if ("layout/fragment_invite_user_request_0".equals(tag)) {
                    return new FragmentInviteUserRequestBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_invite_user_request is invalid. Received: " + tag);
            case 16:
                if ("layout/fragment_long_user_action_menu_0".equals(tag)) {
                    return new FragmentLongUserActionMenuBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_long_user_action_menu is invalid. Received: " + tag);
            case 17:
                if ("layout/fragment_long_user_action_menu_confirm_0".equals(tag)) {
                    return new FragmentLongUserActionMenuConfirmBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_long_user_action_menu_confirm is invalid. Received: " + tag);
            case 18:
                if ("layout/fragment_roulette_home_0".equals(tag)) {
                    return new FragmentRouletteHomeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_roulette_home is invalid. Received: " + tag);
            case 19:
                if ("layout/fragment_roulette_match_success_0".equals(tag)) {
                    return new FragmentRouletteMatchSuccessBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_roulette_match_success is invalid. Received: " + tag);
            case 20:
                if ("layout/fragment_roulette_result_0".equals(tag)) {
                    return new FragmentRouletteResultBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_roulette_result is invalid. Received: " + tag);
            case 21:
                if ("layout/fragment_roulette_welcome_0".equals(tag)) {
                    return new FragmentRouletteWelcomeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_roulette_welcome is invalid. Received: " + tag);
            case 22:
                if ("layout/head_online_status_user_seleced_0".equals(tag)) {
                    return new HeadOnlineStatusUserSelecedBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for head_online_status_user_seleced is invalid. Received: " + tag);
            case 23:
                if ("layout/header_online_status_0".equals(tag)) {
                    return new HeaderOnlineStatusBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for header_online_status is invalid. Received: " + tag);
            case 24:
                if ("layout/item_chat_action_menu_0".equals(tag)) {
                    return new ItemChatActionMenuBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_chat_action_menu is invalid. Received: " + tag);
            case 25:
                if ("layout/item_chat_audio_left_0".equals(tag)) {
                    return new ItemChatAudioLeftBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_chat_audio_left is invalid. Received: " + tag);
            case 26:
                if ("layout/item_chat_audio_right_0".equals(tag)) {
                    return new ItemChatAudioRightBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_chat_audio_right is invalid. Received: " + tag);
            case 27:
                if ("layout/item_chat_menu_0".equals(tag)) {
                    return new ItemChatMenuBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_chat_menu is invalid. Received: " + tag);
            case 28:
                if ("layout/item_chat_system_0".equals(tag)) {
                    return new ItemChatSystemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_chat_system is invalid. Received: " + tag);
            case 29:
                if ("layout/item_chat_text_left_0".equals(tag)) {
                    return new ItemChatTextLeftBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_chat_text_left is invalid. Received: " + tag);
            case 30:
                if ("layout/item_chat_text_right_0".equals(tag)) {
                    return new ItemChatTextRightBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_chat_text_right is invalid. Received: " + tag);
            case 31:
                if ("layout/item_connection_request_0".equals(tag)) {
                    return new ItemConnectionRequestBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_connection_request is invalid. Received: " + tag);
            case 32:
                if ("layout/item_connections_block_0".equals(tag)) {
                    return new ItemConnectionsBlockBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_connections_block is invalid. Received: " + tag);
            case 33:
                if ("layout/item_connections_group_0".equals(tag)) {
                    return new ItemConnectionsGroupBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_connections_group is invalid. Received: " + tag);
            case 34:
                if ("layout/item_connections_letter_0".equals(tag)) {
                    return new ItemConnectionsLetterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_connections_letter is invalid. Received: " + tag);
            case 35:
                if ("layout/item_connections_user_0".equals(tag)) {
                    return new ItemConnectionsUserBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_connections_user is invalid. Received: " + tag);
            case 36:
                if ("layout/item_group_manager_invitation_0".equals(tag)) {
                    return new ItemGroupManagerInvitationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_group_manager_invitation is invalid. Received: " + tag);
            case 37:
                if ("layout/item_group_manager_member_0".equals(tag)) {
                    return new ItemGroupManagerMemberBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_group_manager_member is invalid. Received: " + tag);
            case 38:
                if ("layout/item_manager_group_head_0".equals(tag)) {
                    return new ItemManagerGroupHeadBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_manager_group_head is invalid. Received: " + tag);
            case 39:
                if ("layout/item_online_status_user_0".equals(tag)) {
                    return new ItemOnlineStatusUserBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_online_status_user is invalid. Received: " + tag);
            case 40:
                if ("layout/item_online_status_user_select_0".equals(tag)) {
                    return new ItemOnlineStatusUserSelectBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_online_status_user_select is invalid. Received: " + tag);
            case 41:
                if ("layout/item_report_action_menu_0".equals(tag)) {
                    return new ItemReportActionMenuBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_report_action_menu is invalid. Received: " + tag);
            case 42:
                if ("layout/item_report_choose_img_0".equals(tag)) {
                    return new ItemReportChooseImgBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_report_choose_img is invalid. Received: " + tag);
            case 43:
                if ("layout/item_roulette_selected_0".equals(tag)) {
                    return new ItemRouletteSelectedBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_roulette_selected is invalid. Received: " + tag);
            case 44:
                if ("layout/item_roulette_toy_0".equals(tag)) {
                    return new ItemRouletteToyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_roulette_toy is invalid. Received: " + tag);
            case 45:
                if ("layout/view_multi_velvo_panel_0".equals(tag)) {
                    return new ViewMultiVelvoPanelBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_multi_velvo_panel is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
