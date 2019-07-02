package devrari.sandeep.googletraining;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ActivityContacts extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<GetSetForPhoneContacts> contactsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        tabLayout=findViewById(R.id.contactsTablyouts);
        viewPager=findViewById(R.id.contactsViewPager);
        getAllContacts();
        //String[] stringSet= (String[]) list.get(0).keySet().toArray();
        //Log.w(stringSet[0],list.get(0).get(stringSet[0]));
        ViewPagerFragmentsAdapter viewPagerFragmentsAdapter=new ViewPagerFragmentsAdapter(getSupportFragmentManager());
        viewPagerFragmentsAdapter.setContactsAll(contactsList);
        viewPager.setAdapter(viewPagerFragmentsAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
    private void getAllContacts(){
        ContentResolver contentResolver=getContentResolver();
        String[] contactsTemp={ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts.HAS_PHONE_NUMBER};
        Cursor cursor=contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
                contactsTemp,
                null,
                null,
                null);
        GetSetForPhoneContacts name_number;
        contactsList=new ArrayList<>();
        while(cursor.moveToNext()){
            String name=cursor.getString(cursor.getColumnIndex(contactsTemp[0]));
            String hasNumber=cursor.getString(cursor.getColumnIndex(contactsTemp[1]));
            name_number=new GetSetForPhoneContacts();
            name_number.setContactName(name);
            name_number.setHasContactNumber(hasNumber);
            contactsList.add(name_number);
//            if(hasNUmber.equals("1")){//Boolean.parseBoolean(hasNUmber)){
//                Cursor tempCursor=contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//                        new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER},
//                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"="+name,
//                        null,
//                        null);
//                if(tempCursor.moveToNext()){
//                    String number=tempCursor.getString(tempCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                    Log.w(name,number);
//                    name_number=new HashMap<>();
//                    name_number.put(name,number);
//                    list.add(name_number);
//                }
//                tempCursor.close();
//            }
        }
        cursor.close();
    }
}
